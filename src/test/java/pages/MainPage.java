package pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
	
	WebDriver driver;
	
	By btn_comprar_passagem = By.xpath("//*[@id=\"nav-shopping\"]/a");
	
	By btn_somente_ida = By.xpath("//*[@id=\"TCSS__tabbox-shopping\"]/div[1]/div/fieldset[2]/input");
	
	By txt_origem = By.xpath("//*[@id=\"field-5-origin1\"]");
	
	By sel_origem = By.xpath("//*[@id=\"field-5-origin1\"]");
	
	By txt_destino = By.xpath("//*[@id=\"field-6-destination1\"]");
	
	By sel_destino = By.xpath("//*[@id=\"field-6-destination1\"]");
	
	By data_inicial = By.xpath("//*[@id=\"tab-one-way\"]/div[2]/div[1]/div/button");
	
	By data_in = By.xpath("//input[@id='field-7-departure1']");
	
	By btn_buscar_voo = By.id("searchTicketsButton");
	
	By btn_prosseguir_voo = By.xpath("(//*[@id=\"AvailabilityInputAvailabilityView_LinkButtonSubmit\"])[1]");
		
	
	//Constructor
	public MainPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public void escreverOrigem(String origem) {
		
		driver.findElement(txt_origem).sendKeys(origem);
		WebDriverWait wait = new WebDriverWait(this.driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(sel_origem));
		driver.findElement(sel_origem).sendKeys(Keys.ENTER);
				
	}
	
	public void escreverDestino(String destino) throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(txt_destino).sendKeys(destino);
		WebDriverWait wait = new WebDriverWait(this.driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(sel_destino));
		driver.findElement(sel_destino).sendKeys(Keys.ENTER);
		
	}
	
	public void clickDataInicial() throws InterruptedException {
				
		driver.findElement(data_inicial).click();
		Thread.sleep(5000);
	
        Random aleatorio = new Random();
        int dia = aleatorio.nextInt(90);
        LocalDate dataDePartida = LocalDate.now().plusDays(dia);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        driver.findElement(By.xpath("//input[@id='field-7-departure1']")).sendKeys((dataDePartida.format(formato)).toString());
        driver.findElement(data_in).click();
	}

	
	public void clickBuscar() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(btn_buscar_voo).click();
		
	}
	
	public void clickProsseguir() throws InterruptedException {
		
		Thread.sleep(7000);
		driver.findElement(btn_prosseguir_voo).click();
		
	}
	public void dadosPassageiros() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\'PassengerControlPassengerView_TextBoxFirstName_0\']")).sendKeys("Mateus");
		driver.findElement(By.xpath("//*[@id=\'PassengerControlPassengerView_TextBoxLastName_0\']")).sendKeys("TesteUltimo");
		
		driver.findElement(By.xpath("//*[@id=\"countryDiv\"]/div/button/span[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"countryDiv\"]/div/div/ul/li[2]/a")).click();
		
		driver.findElement(By.xpath("//*[@id=\"PassengerControlPassengerView_TextBoxNationalId_0\"]")).sendKeys("331.076.338-28");
		driver.findElement(By.xpath("//*[@id=\"PassengerControlPassengerView_TextBoxMiddleName_0\"]")).sendKeys("TesteMeio");
        
		Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"informationGenderDiv_0\"]/div/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"informationGenderDiv_0\"]/div/div/ul/li[3]/a/span[1]")).click();
        
        driver.findElement(By.xpath("//*[@id=\"PassengerControlPassengerView_TextBoxBirthDate_0\"]")).sendKeys("30/06/2001");
        driver.findElement(By.xpath("//*[@id=\"PassengerControlPassengerView_TextBoxEmail_0\"]")).sendKeys("teste@gmail.com");
		
        WebElement element = driver.findElement(By.id("PassengerControlPassengerView_LinkButtonSubmit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(By.xpath("//*[@id=\"PassengerControlPassengerView_LinkButtonSubmit\"]")).click();

	}
	
	public void escolherAssentoeServicos() throws InterruptedException {
		
		List<String> letra = Arrays.asList("sistema-grid");
        String select = letra.get(new Random().nextInt(letra.size()));
        Random aleatorio = new Random();
        int poltrona = aleatorio.nextInt(27);
        driver.findElement(By.xpath("//a[contains(@class,'seat -available') and @unit_value_pax_0='R$ 0,00' and @data-seatnumber='"+poltrona+""+select+"']")).click();
        
        Thread.sleep(5000);
        WebElement prosseguir = driver.findElement(By.id("btnProsseguir"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", prosseguir);
        driver.findElement(By.xpath("//*[@id=\"btnProsseguir\"]")).click();
        
        Thread.sleep(5000);
        WebElement prosseguir2 = driver.findElement(By.id("btnContinue"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", prosseguir2);
        driver.findElement(By.xpath("//*[@id=\"btnContinue\"]")).click();
		
	}

	public void cadastroeValidarPagina() throws InterruptedException {
		
        driver.findElement(By.xpath("//*[@id=\"PaymentInputControlCheckoutView_ContactInputControlCheckoutView_TextBoxPostalCode\"]")).sendKeys("04551-000");
        driver.findElement(By.xpath("//*[@id=\"PaymentInputControlCheckoutView_ContactInputControlCheckoutView_TextBoxAddressNumber\"]")).sendKeys("1910");
        driver.findElement(By.xpath("//*[@id=\"PaymentInputControlCheckoutView_ContactInputControlCheckoutView_TextBoxOtherPhone\"]")).sendKeys("1198765432");
		
		Thread.sleep(2000);
        WebElement confirmarReserva = driver.findElement(By.id("selectTerms"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", confirmarReserva);
        driver.findElement(By.xpath("//*[@id=\"selectTerms\"]/label")).click();
        
        WebElement ativo = driver.findElement(By.xpath("//button[@class='btn btn-action btn-next']"));
        JOptionPane.showInputDialog( "Página de pagamento validada com sucesso" + ativo);
		
	}
		
}
