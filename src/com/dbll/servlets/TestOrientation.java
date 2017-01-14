package com.dbll.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.json.JSONArray;

import com.dbll.beans.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Servlet implementation class TestOrientation
 */
@WebServlet("/TestOrientation")
public class TestOrientation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestOrientation() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Question 1
		List<ReponseBean> reponsesQuestion1 = new ArrayList<ReponseBean>();
		reponsesQuestion1.add(new ReponseBean(1, "Des antonymes"));
		reponsesQuestion1.add(new ReponseBean(2, "Des synonymes"));
		reponsesQuestion1.add(new ReponseBean(3, "Des paronymes"));
		QuestionBean q1 = new QuestionBean(1, "Les mots 'effraction'  et 'infraction' sont-ils ?", reponsesQuestion1);

		// Question 2
		List<ReponseBean> reponsesQuestion2 = new ArrayList<ReponseBean>();
		reponsesQuestion2.add(new ReponseBean(1, "Voiture"));
		reponsesQuestion2.add(new ReponseBean(2, "Quinoa"));
		reponsesQuestion2.add(new ReponseBean(3, "Lyre"));
		QuestionBean q2 = new QuestionBean(2, "Parmi les mots suivants, lequel est de genre 'masculin' ?", reponsesQuestion2);

		// Question 3
		List<ReponseBean> reponsesQuestion3 = new ArrayList<ReponseBean>();
		reponsesQuestion3.add(new ReponseBean(1, "-2"));
		reponsesQuestion3.add(new ReponseBean(2, "-1"));
		reponsesQuestion3.add(new ReponseBean(3, "1"));
		QuestionBean q3 = new QuestionBean(3, "Quel est le resultat de l'operation (1 - 2) - (3 - 4) - (5 - 6) ?", reponsesQuestion3);
		
		// Question 4
		List<ReponseBean> reponsesQuestion4 = new ArrayList<ReponseBean>();
		reponsesQuestion4.add(new ReponseBean(1, "31"));
		reponsesQuestion4.add(new ReponseBean(2, "41"));
		reponsesQuestion4.add(new ReponseBean(3, "20"));
		QuestionBean q4 = new QuestionBean(4, "Completer la suite: ROUGE 25 - VERT 60 - JAUNE 24 - BLANC ?", reponsesQuestion4);
		
		List<QuestionBean> testOrientation = new ArrayList<QuestionBean>();
		testOrientation.add(q1);
		testOrientation.add(q2);
		testOrientation.add(q3);
		testOrientation.add(q4);
		
		JSONArray jsonArray = new JSONArray();
		for (int i = 0; i < testOrientation.size(); i++) {
			JSONObject questionJsonObject = new JSONObject(testOrientation.get(i));
			jsonArray.put(questionJsonObject);
		}

		String value = jsonArray.toString();

		response.getWriter().append(value);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ResultatBean r1 = new ResultatBean(1, 3);
		ResultatBean r2 = new ResultatBean(2, 2);
		ResultatBean r3 = new ResultatBean(3, 3);
		ResultatBean r4 = new ResultatBean(4, 1);
		
		List<ResultatBean> listResultat = new ArrayList<ResultatBean>();
		listResultat.add(r1);
		listResultat.add(r2);
		listResultat.add(r3);
		listResultat.add(r4);
		
		String ncin = request.getParameter("ncin");
		String[] reponses = request.getParameterValues("reponses[]");

		String value = null;
		if (!"".equals(ncin) && reponses != null && !"".equals(reponses) && reponses.length == listResultat.size()) {
			// comparaison
			int s = 0;
			for (int i = 0; i < reponses.length; i++) {
				if (Integer.parseInt(reponses[i]) == listResultat.get(i).getReponse_id()) {
					s++;
				}
			}
			// sauvegarde => resultat
			float score = ((float) s / reponses.length) * 100;
			ReponseCandidat reponseCandidat = new ReponseCandidat(ncin, score);
			// reponseCandidat est supposé etre sauvegarder dans la BD !

			JSONObject reponseCandidatJsonObject = new JSONObject(reponseCandidat);
			value = reponseCandidatJsonObject.toString();
		}
		response.getWriter().append(value);
	}

}
