package service;

import domain.Guest;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("guestDao")
public class JpaGuestDao implements GuestDao{
    
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<Guest> findAll() {
        TypedQuery<Guest> query = em.createQuery("SELECT g FROM Guest g ORDER BY g.id",Guest.class);
        return query.getResultList();
    }

    
}
