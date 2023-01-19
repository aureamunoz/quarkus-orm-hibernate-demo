package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BookRepository implements PanacheRepository<Book> {

//    public Book findByPublicationYearBetween(Integer lower, Integer higher){
//        return findByPublicationYearBetween(lower,higher);
//    }
}
