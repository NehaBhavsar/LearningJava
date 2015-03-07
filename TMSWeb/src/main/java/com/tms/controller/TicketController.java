package com.tms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tms.entity.TicketTxn;
import com.tms.service.TicketService;
import com.tms.util.ResponseCode;
import com.tms.vo.SearchTicketResp;
import com.tms.vo.TicketVO;

@Controller
@RequestMapping("/tms")
public class TicketController {

	Logger logger = Logger.getLogger(TicketController.class);
	@Autowired
	TicketService ticketService;

	@RequestMapping("/createticketpage")
	public ModelAndView createTicketpage() {
		logger.info("Inside Crate ticket page");
		TicketVO ticketVO = new TicketVO();
		Map<String, Object> model = new HashMap<String, Object>();

		model.put("ticketList", ticketService.getAllTicketType());
		model.put("ticketvo", ticketVO);
		return new ModelAndView("createticket", model);
	}

	@RequestMapping("/createticket")
	public ModelAndView createTicket(@ModelAttribute TicketVO ticketVO, HttpSession session) {
		logger.info("Inside Creating ticket page" + session.getAttribute("userid"));
		Map<String, Object> model = new HashMap<String, Object>();
		logger.info(ticketVO.getTicket().getTicketId());
		logger.info(ticketVO.getTicketDesc());
		ticketVO.setUserId((Integer) session.getAttribute("userid"));
		int ticketTxnId = ticketService.createTicketTxn(ticketVO);
		model.put("ticketList", ticketService.getAllTicketType());
		model.put("ticketvo", ticketVO);
		session.setAttribute("txnmessage", "Ticket is created successfully with id : " + ticketTxnId);
		return new ModelAndView("createticket", model);
	}

	@RequestMapping("/searchticketpage")
	public ModelAndView searchTicketpage() {
		logger.info("Inside search ticket page");
		 ModelAndView mv = new ModelAndView();
	     mv.setViewName("searchticket");
		return mv;
	}

	@RequestMapping(value = "/ticketDetails", method = RequestMethod.GET)
	public void searchTicketGrid(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("Inside search grid fill up ticket page");
		 response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();;
		try {			
					
			JSONObject responcedata = new JSONObject();
			JSONArray cellarray = new JSONArray();
			JSONArray cell = new JSONArray();
			JSONObject cellobj = new JSONObject();
			float totalCount = 0;
			double pageval=1 ;
			 Long pageNo = null;
			SearchTicketResp resp = ticketService.getAllTicketTxn();
			String pageno = request.getParameter("page");
			pageNo =(pageno != null) ? Long.parseLong(pageno) : null;
			String rows = request.getParameter("rows");

			if (resp.getResp().getRespCode().equals(ResponseCode.SUCCESS)) {
				// for pagination
				
							//String sidx = request.getParameter("sidx");
				//final String sord = request.getParameter("sord");
				
				logger.info("Rows :" + rows + " | Pageno: " + pageNo);
				 Long startPageIndex = (Long.parseLong(pageno) - 1) * Long.parseLong(rows);
				logger.info("start page :" + startPageIndex);
				totalCount =  resp.getTotalCount();
				logger.info("$$$$$$$$Count for ticket : " + totalCount);
				pageval = (float) Math.ceil(totalCount / Integer.parseInt(rows));
			}else{
				List<TicketTxn> list = Collections.<TicketTxn>emptyList();
			}

			for(TicketTxn txn : resp.getTicketTxns()){
				cellobj.put("id", txn.getTxnId());
				cell.add(txn.getTxnId());
				cell.add(txn.getMstTicket().getTicketType());
				cell.add(txn.getMstUser4().getUserName());
				cell.add(txn.getCreatedOn().toString());
				cell.add(txn.getMstStatus().getStatusName());
				cellobj.put("cell", cell);
	            cell.clear();
	            cellarray.add(cellobj);
			}
			 responcedata.put("total", pageval);
	         responcedata.put("page", pageNo);
	         responcedata.put("records", totalCount);
	         responcedata.put("rows", cellarray);
	        
	         out.print(responcedata);
		} catch (Exception e) {
			 out.close();
			e.printStackTrace();
		}
		
	}

}
