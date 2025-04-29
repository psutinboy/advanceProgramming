import javax.servlet.ServletException;

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  String name = request.getParameter("name");
  String age = request.getParameter("age");
  String diagnosis = request.getParameter("diagnosis");
  response.getWriter().println("Name: " + name + " Age: " + age + " Diagnosis: " + diagnosis);

  response.setContentType("text/html");
  PrintWriter out = response.getWriter();
  out.println("<html><body>");
  out.println("<h1>Patient Information</h1>");
  out.println("<p>Name: " + name + "</p>");
  out.println("<p>Age: " + age + "</p>");
  out.println("<p>Diagnosis: " + diagnosis + "</p>");
}
