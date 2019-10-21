package bg.finance.controllers;

import bg.finance.models.Expense;
import bg.finance.repositories.ExpenseRepository;
import bg.finance.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@RestController
public class ExepenseController {
    @Autowired
    private ExpenseRepository expenseRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/expenses")
    public void addExpense(@RequestBody List<Expense> expenses){
        //Setting id to 0, so the DB will handle the PK Incrementation
        //Setting userId to the currently logged-in user
        for(Expense expense : expenses){
            expense.setUser(UserUtils.getCurrentUserId());
            expenseRepository.save(expense);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/expenses")
    public void deleteUserExpenses(){
        expenseRepository.deleteByUser(UserUtils.getCurrentUserId());
    }


    @RequestMapping(value = "/expenses")
    public List<Expense> getExpensesByUsedId(){
        return expenseRepository.findByUser(UserUtils.getCurrentUserId());
    }

}
