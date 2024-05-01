

public class GestionBaseDeDonnees {
    // Informations de connexion à la base de données MySQL
    static final String URL = "jdbc:mysql://localhost:3306/nom_de_votre_base_de_donnees";
    static final String UTILISATEUR = "votre_utilisateur";
    static final String MOT_DE_PASSE = "votre_mot_de_passe";

    public static void main(String[] args) {
        Connection connexion = null;
        Statement statement = null;
        try {
            // Connexion à la base de données
            connexion = DriverManager.getConnection(URL, UTILISATEUR, MOT_DE_PASSE);
            
            // Création d'une instruction SQL
            statement = connexion.createStatement();
            
            // Exécution de la requête SQL (exemple d'insertion d'un étudiant)
            String sql = "INSERT INTO Etudiant (nom, prenom, email, mot_de_passe) VALUES ('John', 'Doe', 'john.doe@example.com', 'password123')";
            statement.executeUpdate(sql);
            
            // Exemple de requête de sélection pour récupérer tous les étudiants
            sql = "SELECT * FROM Etudiant";
            ResultSet result = statement.executeQuery(sql);
            
            // Parcours des résultats et affichage des données
            while (result.next()) {
                int id = result.getInt("id");
                String nom = result.getString("nom");
                String prenom = result.getString("prenom");
                String email = result.getString("email");
                System.out.println("ID: " + id + ", Nom: " + nom + ", Prénom: " + prenom + ", Email: " + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermeture des ressources
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connexion != null) {
                    connexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}