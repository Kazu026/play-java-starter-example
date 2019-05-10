package controllers;

import models.Gender;
import models.OmikujiResult;
import play.mvc.*;
import play.data.FormFactory;
import play.data.DynamicForm;
import views.html.*;

import javax.inject.Inject;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {
    @Inject
    private FormFactory formFactory;//formの入出力管理

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(index.render("Your new application is ready."));

    }

    public Result omikuji(Http.Request request){
        DynamicForm requestData = formFactory.form().bindFromRequest(request);
        OmikujiResult r = new OmikujiResult();
        r.userName = requestData.get("userName");
        r.gender = (requestData.get("gender").equals("m"))? Gender.MALE:Gender.FEMAL;
        r.birthMonth = Integer.parseInt(requestData.get("birthMonth"));

        r.omikuji();
        return ok(omikuji.render(r));
    }

}
