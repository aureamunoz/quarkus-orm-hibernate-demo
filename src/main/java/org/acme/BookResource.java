package org.acme;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    BookRepository bookRepository;

    @GET
    public List<Book> findAll(){
        return bookRepository.listAll();
    }

    @DELETE
    @Transactional
    @Path("/{íd}")
    public void deleteBook(Long id){
        Book entity = bookRepository.findById(id);
        if (entity == null) {
            throw new NotFoundException();
        }
        bookRepository.delete(entity);
    }

}
