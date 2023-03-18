package com.jonhdev.controller;

import com.jonhdev.entities.Book;
import com.jonhdev.proxy.CambioProxy;
import com.jonhdev.repository.BookRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Book Endpoint")
@RestController
@RequestMapping(value = "book-service")
public class BookController {

    @Autowired
    private Environment environment;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CambioProxy cambioProxy;

    @Operation(summary = "Find specific book by your ID")
    @GetMapping(value = "/{id}/{currency}")
    public Book findBookById(@PathVariable Long id, @PathVariable String currency) {

        var book = bookRepository.getById(id);
        if (book == null) throw new RuntimeException("Book not found");

        /* Comunicação via Rest Template */

        /* HashMap<String, String> params = new HashMap<>();
        params.put("amount", book.getPrice().toString());
        params.put("from", "USD");
        params.put("to", currency);

        var response = new RestTemplate().getForEntity("http://localhost:8000/cambio-service/{amount}/{from}/{to}", Cambio.class, params); */

        var cambio = cambioProxy.getCambio(book.getPrice(), "USD", currency);
        var port = environment.getProperty("local.server.port");
        book.setEnvironment("Book port: " + port + " - " + cambio.getEnvironment());
        book.setPrice(cambio.getConvertedValue());
        return book;
    }
}
