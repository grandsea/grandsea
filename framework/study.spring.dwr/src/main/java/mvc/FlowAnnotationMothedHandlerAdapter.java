package mvc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

public class FlowAnnotationMothedHandlerAdapter extends
		AnnotationMethodHandlerAdapter {
	
	protected ModelAndView invokeHandlerMethod(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		ModelAndView result = null;
		try {
			result = super.invokeHandlerMethod(request, response, handler);
			result.addObject("success", Boolean.valueOf(true));
		} catch (Exception e) {
			e.printStackTrace();
			result = new ModelAndView();
			result.addObject("success", Boolean.valueOf(false));
			result.addObject("errorMessage", e.getMessage());
		}
		if (result.getView() == null)
			result.setView(new JSONView());

		return result;
	}

	static class JSONView implements View {
		static Collection<Pattern> excludeProperties = new ArrayList<Pattern>();
		private boolean writeGzip;

		JSONView() {
			this.writeGzip = false;
		}

		public void setWriteGzip(boolean writeGzip) {
			this.writeGzip = writeGzip;
		}

		public String getContentType() {
			return "text/plain";
		}

		public void render(Map model, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			JSONObject writer;
			try {
				writer = JSONObject.fromObject(model);
				String json = writer.toString();

				response.setContentType(getContentType());
				response.setCharacterEncoding("UTF-8");

				response.getWriter().write(json);
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}

		static {
			excludeProperties.add(Pattern.compile("org.springframework.*"));
		}
	}
}
