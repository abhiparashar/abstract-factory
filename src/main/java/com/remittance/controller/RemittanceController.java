package com.remittance.controller;

import com.remittance.dto.*;
import com.remittance.service.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/remittance")
@Validated
@CrossOrigin(origins = "*",maxAge = 3600)
public class RemittanceController {
    @Autowired
    private RemittanceService remittanceService;

    @Operation(summary = "Get quote for remittance transfer")
    @PostMapping("/get-quote")
    public ResponseEntity<ApiResponse<QuoteResponse>>getQuote(@Valid @RequestBody QuoteRequest request){
        try{
            QuoteResponse quoteResponse = remittanceService.getQuote(request);
            return ResponseEntity.ok(new ApiResponse<>(true, "Quote calculated successfully", quoteResponse));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(new ApiResponse<>(false, "Error calculating quote: " + e.getMessage(), null));
        }
    }

}
