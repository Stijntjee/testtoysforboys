package be.vdab.testtoysforboys.repositories;

import be.vdab.testtoysforboys.domain.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaOrderRepository implements OrderRepository
{
    private EntityManager manager;

    //CONSTRUCTORS
    JpaOrderRepository(EntityManager manager)
    {
        this.manager = manager;
    }

    //METHODS
    @Override
    public Optional<Order> findById(long id) {
        return Optional.ofNullable(manager.find(Order.class, id));
    }

    @Override
    public List<Order> findUnshipped() {
        return manager.createQuery("SELECT o FROM Order o WHERE o.status NOT IN ('SHIPPED''CANCELLED')", Order.class).getResultList();
    }
}
