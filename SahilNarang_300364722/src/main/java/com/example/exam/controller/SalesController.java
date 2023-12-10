package com.example.exam.controller;

import com.example.exam.dao.ItemsDao;
import com.example.exam.entity.Sale;
import com.example.exam.model.Items;
import com.example.exam.model.Salesman;
import com.example.exam.model.SaveSaleRequest;
import com.example.exam.repository.SalesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Random;

@Controller
@RequiredArgsConstructor
@RequestMapping("/sales")
@Slf4j
public class SalesController {

    Random random = new Random();
    private final SalesRepository salesRepository;
    private final ItemsDao itemsDao;

    @GetMapping
    public String getForm(Model model, @ModelAttribute("req") SaveSaleRequest req) {
        List<Salesman> items = itemsDao.findAll();
        model.addAttribute("items", items);
        model.addAttribute("cats", itemsDao.getCategories());
        model.addAttribute("sales", salesRepository.findAll());
        return "sales_form";
    }

    @PostMapping
    public String save(@ModelAttribute("req") SaveSaleRequest req) {
        log.info(req.toString());

        Sale sale = Sale.builder()
                .salesmanname(req.getSalesmanname())
                .item(req.getItem())
                .amount(req.getAmount())
                .transactionDate(req.getTransactionDate())
                .build();
        salesRepository.save(sale);
        log.info("Sale: {} has been successfully saved", sale);
        return "redirect:/sales";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        log.info("Deleting for id {}", id);
        salesRepository.deleteById(id);
        return "redirect:/sales";
    }
}
