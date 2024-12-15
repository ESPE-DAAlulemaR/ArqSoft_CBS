package com.banquito.cbs.financialproducts.service;

import com.banquito.cbs.financialproducts.model.Account;
import com.banquito.cbs.financialproducts.model.Card;
import com.banquito.cbs.financialproducts.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    public List<Card> getAll() {
        return cardRepository.findAll();
    }

    public Card find(Long id) {
        return cardRepository.findById(id).orElse(null);
    }

    public void save(Card card) {
        cardRepository.save(card);
    }

    public void destroy(Card card) {
        cardRepository.delete(card);
    }
}
