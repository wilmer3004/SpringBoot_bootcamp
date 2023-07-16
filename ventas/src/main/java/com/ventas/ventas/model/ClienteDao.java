// package com.ventas.ventas.model;

// import java.util.List;

// import javax.persistence.EntityManager;
// import javax.persistence.PersistenceContext;


// import org.springframework.stereotype.Repository;
// import org.springframework.transaction.annotation.Transactional;

// @Repository
// public class ClienteDao implements ICliente{
//     @PersistenceContext 
//     private EntityManager em;
//     @SuppressWarnings("unchecked")
//     @Transactional(readOnly = true)
//     @Override
//     public List<Cliente> findAll() {
//         return em.createQuery("from Cliente").getResultList();
//     }
//     @Transactional
//     @Override
//     public void save(Cliente cliente) {
//         if(cliente.getId() != null && cliente.getId() > 0){
//             em.merge(cliente);
//         }
//         else{
//         em.persist(cliente);
//         }
//     }
//     @Transactional(readOnly = true)
//     @Override
//     public Cliente findOne(int id) {
//         return em.find(Cliente.class,id);
//     }
//     @Override
//     @Transactional
//     public void delete(Integer id) {
//         em.remove(findOne(id));
    
//     }


// }
