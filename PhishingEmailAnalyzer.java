public class PhishingEmailAnalyzer  {

   public static int scoreCategory (String text, String[] keywords)  {
      int score = 0;
      for (String keyword : keywords) {
         if (text.contains(keyword)) {
            score += 2;
         }
      }
      return score;
   }
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
   
      String[] urgencyKeywords = {"urgent", "immediately", "act now", "final notice", "within 24 hours", "expires", "last chance", "suspended", "deadline"};
   
      String[] threatKeywords = {"permanently closed", "account locked", "unauthorized access", "unusual activity", "suspicious activity", "legal action", "failure to act"};
   
      String[] credentialOrPaymentKeywords = {"verify your account", "confirm your password", "billing information", "update payment", "social security", "login credentials", "wire transfer", "gift card"};
   
      String[] genericGreetingKeywords = {"dear customer", "dear user", "dear member", "valued customer", "dear account holder"};
   
      String[] baitAndIncentiveKeywords = {"you've won", "free", "refund", "prize", "claim your", "congratulations", "invoice attached"};
   
      String[] linkLanguageKeywords = {"click here", "click below", "log in here"};
   
      int urgencyScore = 0;
      int threatScore = 0;
      int credentialOrPaymentScore = 0;
      int genericGreetingScore = 0;
      int baitAndIncentiveScore = 0;
      int linkLanguageScore = 0;
   
      String readyToScanEmail = email.toLowerCase().replaceAll("\\s+", " ");
   
      urgencyScore = scoreCategory(readyToScanEmail, urgencyKeywords);
      threatScore = scoreCategory(readyToScanEmail, threatKeywords);
      credentialOrPaymentScore = scoreCategory(readyToScanEmail, credentialOrPaymentKeywords);
      genericGreetingScore = scoreCategory(readyToScanEmail, genericGreetingKeywords);
      baitAndIncentiveScore = scoreCategory(readyToScanEmail, baitAndIncentiveKeywords);
      linkLanguageScore = scoreCategory(readyToScanEmail, linkLanguageKeywords);
      
      System.out.println("Urgency Score: " + urgencyScore);
      System.out.println("Threat Score: " + threatScore);
      System.out.println("Credential or Payment Score: " + credentialOrPaymentScore);
      System.out.println("Generic Greeting Score: " + genericGreetingScore);
      System.out.println("Bait and Incentive Score: " + baitAndIncentiveScore);
      System.out.println("Link Language Score: " + linkLanguageScore);
   }
}





