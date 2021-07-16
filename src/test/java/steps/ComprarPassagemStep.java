package steps;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pages.MainPage;

public class ComprarPassagemStep {
	private WebDriver driver;
	private MainPage mainpage;
	

	@Dado("que esteja na tela inicial do site")
	public void que_esteja_na_tela_inicial_do_site() {
		System.setProperty("webdriver.chrome.driver", "/Users/brenosousa/Desktop/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.voeazul.com.br/");
	}
	
	@Quando("determino tipo de passagem")
	public void determino_tipo_de_passagem() throws InterruptedException {
	    
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"nav-shopping\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"TCSS__tabbox-shopping\"]/div[1]/div/fieldset[2]/input")).click();
		
	}

	
	@Então("informar uma {string} válida")
	public void informar_uma_válida(String origem) throws InterruptedException {
		
		mainpage = new MainPage(driver);
		
		WebDriverWait wait = new WebDriverWait(this.driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"field-5-origin1\"]")));
		
		mainpage.escreverOrigem(origem);

	}

	@Então("inserir um {string} válido")
	public void inserir_um__destino_válido(String destino) throws InterruptedException {
		
		mainpage.escreverDestino(destino);

	}

	@Então("uma data de ida válida")
	public void uma_data_de_ida_válida() throws InterruptedException {
		
		mainpage.clickDataInicial();

	}

	@Então("clicar em Buscar passagens")
	public void clicar_em_buscar_passagens() throws InterruptedException {

		mainpage.clickBuscar();

	}

	@Então("a tela com as opções de passagens será exibida e prosseguirá")
	public void a_tela_com_as_opcoes_de_passagens_será_exibida_e_prosseguirá() throws InterruptedException {
		
		mainpage.clickProsseguir();
		
	}
	
	@Então("informe os dados do passageiro e prosseguir")
	public void informe_os_dados_do_passageiro_e_prosseguir() throws InterruptedException {
		
		mainpage.dadosPassageiros();
		
	}
	@Então("escolher assento e servicos")
	public void esolher_assento_e_servicos() throws InterruptedException {
		
		mainpage.escolherAssentoeServicos();
		
	}

	@Então("finalizar o cadastro e validar a página de pagamento")
	public void finalizar_o_cadastro_e_validar_a_página_de_pagamento() throws InterruptedException {
		
		mainpage.cadastroeValidarPagina();
		
	}


}
