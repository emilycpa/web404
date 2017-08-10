package com.servlet;

import com.database.DataBaseUtil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * Servlet implementation class PoAction
 */
public class BoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String jsonp = request.getParameter("jsonpcallback");
        String num = request.getHeader("x-up-calling-line-id");
        String mobile = "19999999999";
        JSONObject json = new JSONObject();
        synchronized(this) {
            if(num != null && !num.equals("")) {
                mobile = num.substring(2);
            }
           // System.out.println("sssssss");
            Cookie cookie1 = null;
            //int flag = false;
            boolean isok = true;
            boolean isok1 = false;
            boolean isok3 = true;
            boolean isok4 = true;
            boolean isok2 = true;
            boolean isok5 = true;
            boolean isok6 = true;
            boolean isok7 = true;
            boolean isok8 = true;
            boolean isok11 = true;
            boolean isok31=true;
            boolean isok34=true;
            boolean isok28=true;
            String url = request.getParameter("url");
            cookie1 = getCookieByName(request, "FlagForAbc123123");
            int kk;
            if(cookie1 == null) {
                isok = true;
            } else {
                StringTokenizer st = new StringTokenizer(cookie1.getValue(), "#", true);
                if(st.countTokens() > 8) {
                	System.out.println(st.countTokens());
                    isok = false;
                } else {
                    isok = true;
                }

               
                    while(st.hasMoreElements()) {
                        String ns;
                      
                           

                            ns = st.nextToken();
                            kk = 0;
                            if(ns == "1" || ns.equals("1")) {
                                isok1 = false;
                            }

                            if(ns == "2" || ns.equals("2")) {
                                isok2 = false;
                            }

                            if(ns == "3" || ns.equals("3")) {
                                isok3 = false;
                            }

                            if(ns == "4" || ns.equals("4")) {
                                isok4 = false;
                            }

                            if(ns == "5" || ns.equals("5")) {
                                isok5 = false;
                            }

                            if(ns == "6" || ns.equals("6")) {
                                isok6 = false;
                            }

                            if(ns == "7" || ns.equals("7")) {
                                ++kk;
                            }

                            if(ns == "11" || ns.equals("11")) {
                                isok11 = false;
                            }
                            if(ns == "8" || ns.equals("8")) {
                                isok8 = false;
                            }
                            if(ns=="31"||ns.equals("31"))
                            {
                                isok31=false;
                            }
                            if(ns=="34"||ns.equals("34"))
                            {
                                isok34=false;
                            }
                            if(ns=="28"||ns.equals("28"))
                            {
                                isok28=false;
                            }

                            if(kk >= 2) {
                                isok7 = false;
                            }
                        } 
                    
               
            }

            int d = DataBaseUtil.getDomainConut(url);
             if(mobile != "19999999999" && isok) {
            	// if(isok){
              //  System.out.println("d is "+d);
                Vector<Integer> v1 = DataBaseUtil.getList(mobile);
                //System.out.println("v1.size="+v1.size());
//               for (int i=0;i<v1.size();i++)
//               {
//                   System.out.println(v1.get(i).toString());
//               }
                if(isok1 || isok3) {
                    isok1 = false;
                    isok3 = false;
                    if(v1.indexOf(new Integer(d)) == -1) {
                        if(d == 3) {
                            isok3 = true;
                        } else if(d == 1) {
                            isok1 = true;
                        }
                    }
                }

                if(isok11) {
                    if(v1.indexOf(Integer.valueOf(11)) == -1 && d == 11) {
                        isok11 = true;
                    } else {
                        isok11 = false;
                    }
                }

                if(isok2) {
                    if(v1.indexOf(Integer.valueOf(2)) == -1 && v1.indexOf(Integer.valueOf(99)) == -1) {
                        isok2 = false;
                    } else {
                        isok2 = false;
                    }
                }

                if(isok4) {
                    if(v1.indexOf(Integer.valueOf(4)) == -1 && d == 4) {
                        isok4 = true;
                    } else {
                        isok4 = false;
                    }
                }

                if(isok5) {
                    if(v1.indexOf(Integer.valueOf(5)) == -1) {
                        isok5 = true;
                        //System.out.println("555555555");
                    } else {
                        isok5 = false;
                    }
                }

                if(isok6) {
                    if(v1.indexOf(Integer.valueOf(6)) == -1 && DataBaseUtil.getConutHours1(mobile, 5) > 0) {
                        isok6 = true;
                    } else {
                        isok6 = false;
                    }
                }

                if(isok7) {
                    kk = 0;

                    for(int i = 0; i < v1.size(); ++i) {
                        if(((Integer)v1.get(i)).intValue() == 7) {
                            ++kk;
                        }
                    }

                    if(kk < 2&&(d==30||d==27||d==29||d==33||d==23||d==24)) {
                        isok7 = true;
                    } else {
                        isok7 = false;
                    }
                }

//                if(isok8) {
//                    if(v1.indexOf(Integer.valueOf(8)) == -1 && DataBaseUtil.getConutHours1(mobile, 6) > 0) {
//                        isok8 = true;
//                    } else {
//                        isok8 = false;
//                    }
//                }
//                if(isok31)
//                {
//                    if(d==34&&v1.indexOf(Integer.valueOf(31))==-1)
//                    {
//                    	
//                        isok31=false;//取消31
//                    }
//                    else
//                    {
//                        isok31=false;
//                    }
//                }
                if(isok34)
                {
                    if((d==34||d==35)&&v1.indexOf(Integer.valueOf(34))==-1&&DataBaseUtil.getConutHours1(mobile, 6) > 0)
                    {
                    	
                        isok34=true;
                    }
                    else
                    {
                        isok34=false;
                    }
                }
                if(isok28)
                {
                    if((d==28||d==22)&&v1.indexOf(Integer.valueOf(28))==-1&&DataBaseUtil.getConutHours1(mobile, 6) > 0)
                    {
                    	
                        isok28=true;
                    }
                    else
                    {
                        isok28=false;
                    }
                }
                if(v1.size()>=4) {
                    json.put("status", "1");
                    json.put("dese", "4");
                }
                else if(isok11) {
                    json.put("status", "0");
                    json.put("dese11", "11");
                } else if(isok5) {
                    json.put("status", "0");
                    json.put("dese5", "5");
                } else if(isok4) {
                    json.put("status", "0");
                    json.put("dese4", "4");
                } else if(isok6) {
                    json.put("status", "0");
                    json.put("dese6", "6");
                }
                else if(isok34)
                {
                	json.put("status", "0");
                    json.put("dese34", "34");
                }
                else if(isok28)
                {
                	json.put("status", "0");  
                    json.put("dese28", "28");
                }
                else if(isok7)
                {
                	json.put("status", "0");
                    json.put("dese7", "7");
                }
                else {
                    json.put("status", "2");
                    json.put("dese0", "5");
                }
            } else {
                json.put("status", "1");
                json.put("dese", "4");
            }
        }

        PrintWriter out = null;

        try {
            out = response.getWriter();
            //System.out.println(json.toString());
            out.println(jsonp + "(" + json.toString() + ")");
        } catch (IOException var30) {
            var30.printStackTrace();
        } finally {
            if(out != null) {
                out.close();
            }

        }

    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private static Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
		Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
		Cookie[] cookies = request.getCookies();

		if (null != cookies) {

			for (Cookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie);
			}
		} else {

		}
		return cookieMap;
	}

	public static Cookie getCookieByName(HttpServletRequest request, String name) {
		Map<String, Cookie> cookieMap = ReadCookieMap(request);

		if (cookieMap.containsKey(name)) {
			Cookie cookie = (Cookie) cookieMap.get(name);
			return cookie;
		} else {
			return null;
		}
	}

}
