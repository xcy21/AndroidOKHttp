package okServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBmanager.DBUtils;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("registerUsername");
		String pwd = request.getParameter("registerPassword");
		boolean flag = false;
		DBUtils db = new DBUtils();
		db.openConnect();
		
		if(db.isExistInDB(name, pwd)) {
			System.out.println("�˻��Ѵ���");
			flag = false;
			
		}else if(!db.insertDataToDB(name, pwd)){
			flag = true;
			System.out.println("ע���˺ţ�"+name+",ע�����룺"+pwd+",ע������"+flag);
		}else {
			System.out.print("ע��ʧ��");
		}
		
		response.setCharacterEncoding("UTF-8");
		try {
	        response.getWriter().print(flag); 
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        response.getWriter().close(); // �ر����������Ȼ�ᷢ�������
	    }	
	    db.closeConnect();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
