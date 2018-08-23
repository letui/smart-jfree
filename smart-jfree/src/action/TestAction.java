package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfreehelper.api.ChartInjector;
import org.jfreehelper.api.impl.DefaultChartThemeManager;
import org.jfreehelper.util.DatasetManager;
import test.ZhiBiao;

/**
 * Servlet implementation class TestAction
 */
public class TestAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestAction() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setAttribute("z", new ZhiBiao("小红",10,11));
		request.setAttribute("itemMap", DatasetManager.getFieldAnnotationsMap(ZhiBiao.class));
		List<ZhiBiao> zhibiaolist=new ArrayList<ZhiBiao>();
		zhibiaolist.add(new ZhiBiao("小红",10,11));
		zhibiaolist.add(new ZhiBiao("小白",12,14));
		zhibiaolist.add(new ZhiBiao("小黑",13,15));
		zhibiaolist.add(new ZhiBiao("小灰",14,16));
		//定义数据集
		DefaultCategoryDataset ds=null;

		//区别反转
		if(request.getParameter("reverse")==null){
			ds=DatasetManager.updateDataset(zhibiaolist,request.getParameterValues("index"),false);
		}else{
			
			ds=DatasetManager.updateDataset(zhibiaolist,request.getParameterValues("index"),true);
		}	
		if(request.getParameterValues("index")!=null){
			String[] indexes=request.getParameterValues("index");
			for (int i = 0; i < indexes.length; i++) {
				System.out.println(indexes[i]);
			}
		}
			
		String imageURL=ChartInjector.self.injectChart(request, ds);
		//区分请求
		if(request.getParameter("reqType")!=null){
			response.getWriter().write(imageURL);
		}else{
			request.getRequestDispatcher("test.jsp").forward(request, response);
		}
	}

}
