package com.sico.api.checkinline.infraestructure.utils;

import com.sico.api.checkinline.domain.port.driver.CheckDigit;
import org.springframework.stereotype.Service;

@Service
public class CheckDigitImpl implements CheckDigit {

    public String calculateDigit(String identificationId) {
        int[] nums = {3, 7, 13, 17, 19, 23, 29, 37, 41, 43, 47, 53, 59, 67, 71};
        int sum = 0;
        for (int i = identificationId.length() - 1, j = 0; i >= 0; i--, j++)
            sum += Character.digit(identificationId.charAt(i), 10) * nums[j];

        int resultDigit = ((sum % 11 > 1) ? (11 - (sum % 11)) : (sum % 11));
        return Integer.toString(resultDigit);
    }
}
