package pl.mazurek.springboot.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import pl.mazurek.springboot.entity.Transactions;
import pl.mazurek.springboot.entity.TransactionDto;
import pl.mazurek.springboot.service.TransactionsService;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TransactionsController {

    private final TransactionsService transactionsService;

    @GetMapping("/all")
    public Iterable<Transactions> findAll() {
        return transactionsService.findAll();
    }

    @GetMapping("/get")
    public Page<TransactionDto> find(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "100") Integer pageSize,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "0") Long categoryCode) {
        return transactionsService.find(page, pageSize, sort, categoryCode);
    }


    @GetMapping("/fill")
    public void fillFromJson() {
        transactionsService.fillFromJson();
    }

    @PostMapping("/add")
    public void add(@RequestBody Transactions transaction){
        transactionsService.save(transaction);
    }

}