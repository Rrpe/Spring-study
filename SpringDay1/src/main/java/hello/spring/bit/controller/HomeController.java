package hello.spring.bit.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hello.spring.bit.dto.DataDTO;
import hello.spring.bit.service.HomeService;

/**
 * Handles requests for the application home page.
 */
@Controller //������̼� ����ó������ �ñ׳��� �ִ� ����
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	HomeService homeService;

	@RequestMapping(value = "/", method = RequestMethod.GET) // ����Ʈ ��
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate);
		
		return "home";
		// home.jsp��  home �̸��� �������Բ� ���� 
	}
	
	/*@RequestMapping("SpringTest1") // url �̸� ���� ����
	public String spring(@RequestParam String data, Model model) { //  ����Ʈ : (@RequestParam String data, Model model) | String data�� home.jsp�κ��� name �̸�
		model.addAttribute("asdf", data);	// asdf�� ���� jsp�� ���� �Ѱ��ٶ� ${asdf}�� �д´�.
		return "SpringTest1"; // .jsp �̸� ���Ϲ�ȯ
	}*/
	
	/*@RequestMapping("SpringTest1") // url �̸� ���� ����
	public String spring(@ModelAttribute DataDTO dto, Model model) { // ����Ʈ : (@ModelAttribute DataDTO dto, Model model)
		model.addAttribute("data1", dto.getData());	
		model.addAttribute("data2", dto.getData2());
		
		return "SpringTest1";
	}*/
	
	@RequestMapping("SpringTest1")
	public String spring(Model model) {
		model.addAttribute("info", homeService.info());
		return "SpringTest1";
	}
}
