package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous �tes d�j� un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("�tes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					System.out.println("Bienvenu villageois " + nomVisiteur + ".\n");
					int force = Clavier.entrerEntier("Quelle est votre force?");
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		System.out.println("Bienvenu druide " + nomVisiteur + ".\n");
		int forceDruide = Clavier.entrerEntier("Quelle est votre force?\n");
		int effetPotionMin;
		int effetPotionMax;
		do {
			effetPotionMin = Clavier.entrerEntier("Quelle est la force de potion la plus faible que vous produisez?");
			effetPotionMax = Clavier.entrerEntier("Quelle est la force de potion la plus forte que vous produisez?");
			if (effetPotionMax < effetPotionMin) {
				System.out.println("Atention Druide, vous vous �tes tromp� entre le minimum et le maximum.\n");
			}
		} while (effetPotionMax < effetPotionMin);
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
	}
}
