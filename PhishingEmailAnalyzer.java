public class PhishingEmailAnalyzer  {
   public static void main(String[] args) {
      String email = """
            From: "PayPal Security" <security-alert@paypa1-support.example.com>
            Reply-To: helpdesk@account-verify.example.net
            Subject: URGENT: Your account has been suspended!
         
            Dear Customer,
         
            We detected unusual activity on your account. Your account has been
            suspended and you must verify your identity within 24 hours or it
            will be permanently closed.
         
            Click here to confirm your password and billing information:
            http://192.0.2.15/secure-login/verify
         
            Failure to act immediately will result in loss of access.
         
            Thank you,
            Security Team
            """;
   
   
   
      String urgencyKeyword1 = "urgent";
      String urgencyKeyword2 = "immediately";
      String urgencyKeyword3 = "act now";
      String urgencyKeyword4 = "final notice";
      String urgencyKeyword5 = "within 24 hours";
      String urgencyKeyword6 = "expires";
      String urgencyKeyword7 = "last chance";
      String urgencyKeyword8 = "suspended";
      String urgencyKeyword9 = "deadline";
      String[] urgencyKeywords = {urgencyKeyword1, urgencyKeyword2, urgencyKeyword3, urgencyKeyword4, urgencyKeyword5, urgencyKeyword6, urgencyKeyword7, urgencyKeyword8, urgencyKeyword9};
   
      String threatKeyword1 = "permanently closed";
      String threatKeyword2 = "account locked";
      String threatKeyword3 = "unauthorized access";
      String threatKeyword4 = "unusual activity";
      String threatKeyword5 = "suspicious activity";
      String threatKeyword6 = "legal action";
      String threatKeyword7 = "failure to act";
      String[] threatKeywords = {threatKeyword1, threatKeyword2, threatKeyword3, threatKeyword4, threatKeyword5, threatKeyword6, threatKeyword7};
   
      String credentialOrPaymentKeyword1 = "verify your account";
      String credentialOrPaymentKeyword2 = "confirm your password";
      String credentialOrPaymentKeyword3 = "billing information";
      String credentialOrPaymentKeyword4 = "update payment";
      String credentialOrPaymentKeyword5 = "social security";
      String credentialOrPaymentKeyword6 = "login credentials";
      String credentialOrPaymentKeyword7 = "wire transfer";
      String credentialOrPaymentKeyword8 = "gift card";
      String[] credentialOrPaymentKeywords = {credentialOrPaymentKeyword1, credentialOrPaymentKeyword2, credentialOrPaymentKeyword3, credentialOrPaymentKeyword4, credentialOrPaymentKeyword5, credentialOrPaymentKeyword6, credentialOrPaymentKeyword7, credentialOrPaymentKeyword8};
   
      String genericGreetingKeyword1 = "dear customer";
      String genericGreetingKeyword2 = "dear user";
      String genericGreetingKeyword3 = "dear member";
      String genericGreetingKeyword4 = "valued customer";
      String genericGreetingKeyword5 = "dear account holder";
      String[] genericGreetingKeywords = {genericGreetingKeyword1, genericGreetingKeyword2, genericGreetingKeyword3, genericGreetingKeyword4, genericGreetingKeyword5};
   
      String baitAndIncentiveKeyword1 = "you’ve won";
      String baitAndIncentiveKeyword2 = "free";
      String baitAndIncentiveKeyword3 = "refund";
      String baitAndIncentiveKeyword4 = "prize";
      String baitAndIncentiveKeyword5 = "claim your";
      String baitAndIncentiveKeyword6 = "congratulations";
      String baitAndIncentiveKeyword7 = "invoice attached";
      String[] baitAndIncentiveKeywords = {baitAndIncentiveKeyword1, baitAndIncentiveKeyword2, baitAndIncentiveKeyword3, baitAndIncentiveKeyword4, baitAndIncentiveKeyword5, baitAndIncentiveKeyword6, baitAndIncentiveKeyword7};
   
      String linkLanguageKeyword1 = "click here";
      String linkLanguageKeyword2 = "click below";
      String linkLanguageKeyword3 = "log in here";
      String[] linkLanguageKeywords = {linkLanguageKeyword1, linkLanguageKeyword2, linkLanguageKeyword3};
   
      int urgencyScore = 0;
      int threatScore = 0;
      int credentialOrPaymentScore = 0;
      int genericGreetingScore = 0;
      int baitAndIncentiveScore = 0;
      int linkLanguageScore = 0;
   
      String readyToScanEmail = email.toLowerCase();
   
      for (int j = 0; j < urgencyKeywords.length; j++) {
         if (readyToScanEmail.contains(urgencyKeywords[j])) {
            urgencyScore += 2;
         }
      }
      for (int k = 0; k < threatKeywords.length; k++) {
         if (readyToScanEmail.contains(threatKeywords[k])) {
            threatScore += 2;
         }
      }
      for (int l = 0; l < credentialOrPaymentKeywords.length; l++) {
         if (readyToScanEmail.contains(credentialOrPaymentKeywords[l])) {
            credentialOrPaymentScore += 2;
         }
      }
      for (int m = 0; m < genericGreetingKeywords.length; m++) {
         if (readyToScanEmail.contains(genericGreetingKeywords[m])) {
            genericGreetingScore += 2;
         }
      }
      for (int n = 0; n < baitAndIncentiveKeywords.length; n++) {
         if (readyToScanEmail.contains(baitAndIncentiveKeywords[n])) {
            baitAndIncentiveScore += 2;
         }
      }
      for (int o = 0; o < linkLanguageKeywords.length; o++) {
         if (readyToScanEmail.contains(linkLanguageKeywords[o])) {
            linkLanguageScore += 2;
         }
      }
      System.out.println("Urgency Score: " + urgencyScore);
      System.out.println("Threat Score: " + threatScore);
      System.out.println("Credential or Payment Score: " + credentialOrPaymentScore);
      System.out.println("Generic Greeting Score: " + genericGreetingScore);
      System.out.println("Bait and Incentive Score: " + baitAndIncentiveScore);
      System.out.println("Link Language Score: " + linkLanguageScore);
   }
}





