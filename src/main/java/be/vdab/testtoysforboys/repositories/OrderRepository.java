package be.vdab.testtoysforboys.repositories;

import be.vdab.testtoysforboys.domain.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository
{
    Optional<Order> findById(long id);
    List<Order> findUnshipped();
}
