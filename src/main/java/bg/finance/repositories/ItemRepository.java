package bg.finance.repositories;

import bg.finance.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    public List<Item> findByUserId(int userId);
    public List<Item> deleteByUserId(int userId);
}
