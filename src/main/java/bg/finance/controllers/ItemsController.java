package bg.finance.controllers;

import bg.finance.models.Item;
import bg.finance.repositories.ItemRepository;
import bg.finance.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
public class ItemsController {

    @Autowired
    ItemRepository repository;

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public List<Item> restoreItems(){
        return repository.findByUserId(UserUtils.getCurrentUserId());
    }

    @RequestMapping(value = "/items", method = RequestMethod.DELETE)
    public List<Item> deleteItems(){
        return repository.deleteByUserId(UserUtils.getCurrentUserId());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/items")
    public void saveItem(@RequestBody List<Item> items){
        for(Item item : items){
            item.setUserId(UserUtils.getCurrentUserId());
            repository.save(item);
        }
    }
}
