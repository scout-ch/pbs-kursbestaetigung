package ch.pbs.benevole.renderer.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.ws.rs.FormParam;
import org.apache.commons.lang3.builder.ToStringBuilder;



import java.io.BufferedReader;
import java.io.StringReader;
import java.util.stream.Collectors;

public class KursParameterJson {

	private String name;
	private String vorname;
	private String wohnort;
	private String dauer;
	private String kursOrt;
	private String organisator;
	private String geburtstag;
	private String anrede;


	@JsonProperty
	public String getName() {
		return name;
	}

	@FormParam("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty
	public String getVorname() {
		return vorname;
	}

	@FormParam("vorname")
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	@JsonProperty
	public String getWohnort() {
		return wohnort;
	}

	@FormParam("wohnort")
	public void setWohnort(String wohnort) {
		this.wohnort = wohnort;
	}

	@JsonProperty
	public String getDauer() {
		return dauer;
	}

	@FormParam("dauer")
	public void setDauer(String dauer) {
		this.dauer = dauer;
	}

	@JsonProperty
	public String getKursOrt() {
		return kursOrt;
	}

	@FormParam("kursOrt")
	public void setKursOrt(String kursOrt) {
		this.kursOrt = removeLeadingAndTrailingEmptyLines(kursOrt);
	}

	@JsonProperty
	public String getOrganisator() {
		return organisator;
	}

	@FormParam("organisator")
	public void setOrganisator(String organisator) {
		this.organisator = organisator;
	}

	@JsonProperty
	public String getGeburtstag() {
		return geburtstag;
	}

	@FormParam("geburtstag")
	public void setGeburtstag(String geburtstag) {
		this.geburtstag = geburtstag;
	}

	@JsonProperty
	public String getAnrede() {
		return this.anrede;
	}

	@FormParam("anrede")
	public void setAnrede(String anrede) {
		this.anrede = anrede;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	private String removeLeadingAndTrailingEmptyLines(String str) {
		return new BufferedReader(new StringReader(str)).lines().dropWhile(String::isBlank).collect(Collectors.collectingAndThen(
				Collectors.toList(),
				list -> {
					int endIndex = list.size();
					while (endIndex > 0 && list.get(endIndex - 1).isBlank()) {
						endIndex--;
					}
					return String.join("\n", list.subList(0, endIndex));
				}
		));
	}

}