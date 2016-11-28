package com.lamfire.wkit.action;

import com.lamfire.wkit.ActionContext;
import com.lamfire.wkit.HttpErrorTemplate;
import com.lamfire.wkit.UserPrincipal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

public class ErrorAction extends Action {

    public void onPermissionDenied(ActionContext context, HttpServletRequest request , HttpServletResponse response, UserPrincipal user,Set<String> permissions){
        writeResponse(response,HttpErrorTemplate.getPermissionDeniedTemplate(request.getServletPath(),permissions));
    }


    public void onActionException(ActionContext context, HttpServletRequest request , HttpServletResponse response,Exception e){
        writeResponse(response,HttpErrorTemplate.getExceptionTemplate(request.getServletPath(),e));
    }

    public final void writeResponse(HttpServletResponse response,String message){
        try {
            response.getOutputStream().write(message.getBytes());
        }catch (Exception e){

        }
    }

}