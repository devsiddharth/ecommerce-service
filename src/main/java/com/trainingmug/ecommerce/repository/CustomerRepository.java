package com.trainingmug.ecommerce.repository;

import com.trainingmug.ecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    //JpaRepository
    /*
    CRUD
    save,findById, delete, findAll
public class CustomerRepository {
    //This layer will be replaced with db operations

    private List<Customer> customers;

    public CustomerRepository(){
        this.customers = new ArrayList<>();
    }

    public Customer save(Customer customer){
        this.customers.add(customer);
        return customer;
    }

    public List<Customer> findAll(){
        return this.customers;
    }

    public Optional<Customer> findById(int id){
        return this.customers.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
    }

    public Optional<Customer> findByEmail(String email){
        return this.customers.stream()
                .filter(c -> c.getEmail().equals(email))
                .findFirst();
    }

    public Customer update(Customer customer){
        this.customers.replaceAll(c -> c.getId() == customer.getId() ? customer : c);
        return customer;
    }

    public void deleteById(int id){
        this.customers.removeIf(c -> c.getId() == id);
    }

    public void delete(Customer customer){
        this.customers.remove(customer);
    }


    Derived Methods
    findBy, count, exists
     */
    //SQL Query
    //select * from customer where email = ?
    Optional<Customer> findByEmail(String email);
    Optional<Customer> findDistinctByEmailAndPassword(String email, String password);
    List<Customer> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);
    List<Customer> findByNameLike(String namePattern);
    List<Customer> findByNameOrderByCreatedAtDesc(String name);


}
