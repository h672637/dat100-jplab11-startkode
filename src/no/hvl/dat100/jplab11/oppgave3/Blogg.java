package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	protected Innlegg[] innleggtabell;
	protected int nesteledig = 0;

	public Blogg() {
		innleggtabell = new Innlegg[20];

	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
	}

	public int getAntall() {
		return nesteledig;
	}

	public Innlegg[] getSamling() {
		return innleggtabell;

	}

	public int finnInnlegg(Innlegg innlegg) {
		for (int i = 0; i < nesteledig; i++) {
			if (innleggtabell[i].erLik(innlegg) == true) {
				return i;
			}

		}
		return -1;

	}

	public boolean finnes(Innlegg innlegg) {
		boolean sjekk = false;
		int pos = finnInnlegg(innlegg);
		if (pos < 0) {
			sjekk = false;
		} else if (innleggtabell[pos].getId() == innlegg.getId()) {
			sjekk = true;
		}
		return sjekk;

	}

	public boolean ledigPlass() {
		boolean sjekk = false;

		if (nesteledig < innleggtabell.length) {
			sjekk = true;
		} else {
			sjekk = false;
		}
		return sjekk;

	}

	public boolean leggTil(Innlegg innlegg) {
		boolean sjekk = false;
		boolean ledig = ledigPlass();
		boolean finn = finnes(innlegg);

		if (ledig == true && finn == false && !sjekk) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			sjekk = true;
		} else {
			sjekk = false;

	}

		return sjekk;

	}

	public String toString() {
		String str = nesteledig+"\n";
		for (int i = 0; i < innleggtabell.length; i++) {
			str += innleggtabell[i].toString();
		}
		return str;

	}

	// valgfrie oppgaver nedenfor

	public void utvid() {
		throw new UnsupportedOperationException(TODO.method());
	}

	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());

	}

	public boolean slett(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
	}

	public int[] search(String keyword) {

		throw new UnsupportedOperationException(TODO.method());

	}
}