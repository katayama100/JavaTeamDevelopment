package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Validate
 */


@WebServlet("/Validate")
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		MandatoryCheck(request,response);
		
//		aaa(request.getParameter("name"));
			
//		String strNum1 = request.getParameter("num1");
		// Confirmを表示させる
//		RequestDispatcher dispatcher =
//				request.getRequestDispatcher("/WEB-INF/jsp/Confirm.jsp");
//		dispatcher.forward(request, response);
		
//		String nextPage;
//		nextPage = "..../jsp/Confirm.jsp";
//		RequestDispatcher rd = getServletContext().getRequestDispatcher(nextPage);
//		rd.forward(request, response);			
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("LLLL=");
		doGet(request, response);
		// 文字コードの設定
//		request.setCharacterEncoding("UTF-8");
//		リクエストパラメータを取得
//		String name = request.getParameter("name");
//		String kanji = request.getParameter("kanji");
	}

	 //##### ArrayList to store error messages
    //##### エラーメッセージを格納するためのArrayList
    public ArrayList<String> errs = new ArrayList<String>();

    //[Common] Transform the error ArrayList to a <ul> list
    //##### getErrorList()メソッド：【必須入力チェック】
    //##### エラーメッセージを格納したArrayList「errs」のメッセージをHTML形式に整形（タグを付与）したり、文字色 を赤くする処理をしています。
    //##### StringBuffer型の変数に格納していき、その結果を戻り値にしています。
    public String getErrorList() {
                    StringBuffer buf = new StringBuffer();
                    buf.append("<ul style='color:Red'>");
                    if(errs.size()>0) {
                                    for(int i=0; i<errs.size(); i++) {
                                                    buf.append("<li>"+errs.get(i)+"</li>");
                                    }
                    }
                    buf.append("</ul>");
                    System.out.println("LLLL="+buf.toString());
                    return buf.toString();
    }
    
    //[Common] Mandatory Check
    //#####　requiredCheck()メソッド
    //#####　必須入力チェックを行うメソッドです。
    public void requiredCheck(String value, String name) {
                    //もし「引数（value）がnull」OR「引数（value）の空白削除値が空」なら
                    if(value==null || value.trim().isEmpty()) {
                                    //入力値がブランクであると見なし、入力を求めるメッセージを出力
                                    errs.add(name+" is a mandatory field. Please enter a value.");
                    }
    }
    
    
    // 必須入力チェックの全体処理
    //##### 入力値の取得→必須チェック→エラーメッセージのセット→画面遷移までの一連の処理を行うメソッド
    public void MandatoryCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                    errs = new ArrayList<String>();
                    String v_name = request.getParameter("g_name");

                    //#####　Forward back to the "Engeki_GroupMaintenance" with Error message
                    //#####　もし必須入力のいずれかが「null」OR「ブランク」の場合
                    if(v_name==null || v_name=="") {
                                    //##### 必須入力項目のチェックを実行
                                    //##### （requiredCheckを実行して空なら「[項目名] is a mandatory～」のエラーメッセージがArrayListに格納される）
                                    requiredCheck(request.getParameter("g_name"),"[Your Name]");
                                    //##### エラーメッセージをリクエストの属性としてセット
                                    request.setAttribute("error_msg", getErrorList());

                                    //##### エラーメッセージを表示するため、再び項目の入力画面に戻る
                                    String nextpage="/TeamDevelopment/jsp/Type.jsp";
                                    RequestDispatcher rd = getServletContext().getRequestDispatcher(nextpage);
                                    rd.forward(request, response);
                    }
                    //#####　Forward to next screen "Engeki_GroupSummary"
                    //#####　必須入力項目がnullかブランクでない場合、各項目の値をリクエストの属性（末尾に2を付けた項目名）としてセットしていく
                    else {
                                    //##### バリデーションの結果問題なければ、次画面に遷移する
                                    String nextpage="/TeamDevelopment/jsp/Confirm.jsp";
                                    RequestDispatcher rd = getServletContext().getRequestDispatcher(nextpage);
                                    rd.forward(request, response);
                    }
    }
    
    

}
