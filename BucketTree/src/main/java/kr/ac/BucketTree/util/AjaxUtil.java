package kr.ac.BucketTree.util;
 
import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.http.HttpServletResponse;
 
public class AjaxUtil {
 
    public static void sendResponse(HttpServletResponse response, String message){
        
        PrintWriter writer = null;
        try {
            
            writer = response.getWriter();
            writer.write(message);
            writer.flush();
            
        } catch (IOException e) {
            // 메시지, 커즈
            throw new RuntimeException(e.getMessage(), e);
        }
        finally{
            if(writer != null){
                writer.close();
            }
        }
    }
    
    
}
