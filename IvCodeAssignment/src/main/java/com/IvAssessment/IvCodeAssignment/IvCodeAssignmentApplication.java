package com.IvAssessment.IvCodeAssignment;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IvCodeAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(IvCodeAssignmentApplication.class, args);

		//Problem 1 - 1000th member of the series 1 2 5 20 25 150 157 1256...

		System.out.println("");
		System.out.println("Problem 1 =================================");
		System.out.println("");

		long Value = 1;
		int n = 1;
		int k = 0;
		int AskedNum = 0;
		AskedNum = 1000;

		for(int i = 1; i < AskedNum; i++){
			k = i % 2;
			if (k == 1){
				n += 1;
				Value = Value * n;
			}else{
				n += 1;
				Value = Value + n;
			}

		} System.out.println("The " + AskedNum + "th member of the series is = " + Value);

		//Problem 2 - replace 'a' follow the rule 1 & rule 2

		System.out.println("");
		System.out.println("Problem 2 =================================");
		System.out.println("");

		String[] string = {"abcdaabcdeabaaacbfaaaabcab","123aabcaabca35aa"};

        for (String s : string) {
            String replace_AA = StringUtils.replaceIgnoreCase(s, "aa", "a$");
            String replace_A$ = StringUtils.replaceIgnoreCase(replace_AA, "$a", "$$");
            String replace_Hash = StringUtils.replaceIgnoreCase(replace_A$, "a", "#");
            String replace_Hash$ = StringUtils.replaceIgnoreCase(replace_Hash, "#$", "a$");
            System.out.println(replace_Hash$);
        }
    }

}
