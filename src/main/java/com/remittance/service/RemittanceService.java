package com.remittance.service;

import com.remittance.dto.QuoteRequest;
import com.remittance.dto.QuoteResponse;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RemittanceService {
    public QuoteResponse getQuote(QuoteRequest quote){
        QuoteResponse quoteResponse = null;
        return quoteResponse;
    }
}
