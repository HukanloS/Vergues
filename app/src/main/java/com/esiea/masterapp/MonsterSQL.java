package com.esiea.masterapp;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {MonsterActivity.class}, version = 1, exportSchema = false)
public abstract class MonsterSQL extends RoomDatabase {

    private static MonsterSQL instance;
    public abstract MonsterInterface monInterface();
    public static synchronized MonsterSQL getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),MonsterSQL.class, "monster_database")
                    .fallbackToDestructiveMigration().addCallback(callback).build();
        }
        return instance;
    }
    private static RoomDatabase.Callback callback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new FillAsynchroneSQL(instance).execute();
        }
    };
    private static class FillAsynchroneSQL extends AsyncTask <Void, Void, Void>{
        private MonsterInterface monsterI;
        private FillAsynchroneSQL(MonsterSQL database){
            monsterI = database.monInterface();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            monsterI.insertion(new MonsterActivity(1,"Seltas","Neopteron","Acide, Tranquilisant",
                    "Foudre, Feu",1,"Un Neopteron qui utilise des mouvements aériens rapides" +
                    " pour attaquer les intrus au sol. Les appendices pointus de sa tête rendent ses attaques très " +
                    "dangereuses, même s'il rate parfois sa cible pour s'écraser sur le sol"));
            monsterI.insertion(new MonsterActivity(2,"Seltas du désert","Neopteron","Paralysie",
                    "Glace, Foudre",1,"Les cornes de ce Neopteron de taille moyenne ainsi " +
                    "que la portée de son attaque des antérieurs le différencient de ses cousins ordinaires. Les Seltas " +
                    "du désert sont réputés pour leur capacité à creuser dans le sol."));
            monsterI.insertion(new MonsterActivity(3,"Reine Seltas","Neopteron","Eau, Asphyxie, Impact",
                    "Feu, Glace",3,"Ne pouvant voler, ces femelles Neopteron dépourvues " +
                    "d'ailes libèrent des phéromones pour attirer et soumettre les mâles Seltas. Les Reines Seltas ont " +
                    "une très lourde carapace, mais leur gueule qui crache du mucus est vulnérable si exposée."));
            monsterI.insertion(new MonsterActivity(4,"Reine Seltas du désert","Neopteron","Asphyxie",
                    "Glace, Foudre",4,"Ce grand Neopteron utilise les pinces situées à l'extrémité " +
                    "de sa queue pour agripper les mâles Seltas ou toute menace. Une fois qu'une spécimen de cette sous-espèce " +
                    "tient un mâle, il lui arrive de le jeter violemment sur les ennemis."));
            monsterI.insertion(new MonsterActivity(5,"Nerscylla","Temnoceran","Poison, Sommeil, " +
                    "Immobilisation", "Feu, Foudre",2,"Un Temnoceran qui tisse des toiles pour " +
                    "chasser et défendre son territoire. Il piège les proies affaiblies par des maladies et les dévore avec " +
                    "ses mandibules géantes. Il adore porter les peaux laissées par les Gypceros qu'il consomme.."));
            monsterI.insertion(new MonsterActivity(6,"Nerscylla spectrale","Temnoceran","Paralysie, Poison, " +
                    "Immobilisation", "Glace, Feu",3,"Ce Temnoceran désertique attire ses proies dans" +
                    " des pièges enfouis sous le sable, puis les déchiquette à l'aide de ses mandibules acérées. Tout comme son " +
                    "cousin ordinaire, il porte la peau de ses victimes."));
            monsterI.insertion(new MonsterActivity(7,"Kecha Wacha","Pelagus","Eau", "Feu, " +
                    "Foudre",1,"Une bête à crocs aux membres adaptés aux mouvements en forêt. Des membranes sur " +
                    "ses pattes avant lui permettent de planer. En cas de menace, il protège sa tête avec ses oreilles géantes, " +
                    "bloquant les sons forts ou la lumière vive."));
            monsterI.insertion(new MonsterActivity(8,"Kecha Wacha blanc","Pelagus","Feu", "Eau, " +
                    "Glace, Foudre",2,"Comme le Kecha Wacha ordinaire, cette créature arboricole à grandes " +
                    "dents utilise ses oreilles pour protéger son visage quand on la provoque. Cette sous-espèce à la fourrure " +
                    "rose pâle se distingue par sa capacité à cracher des boules de feu."));
            monsterI.insertion(new MonsterActivity(9,"Congalala","Pelagus","Asphyxie, Sommeil, Poison, " +
                    "Paralysie, Feu", "Feu",1,"Grand Pelagus dont la fourrure rose est souvent aperçue" +
                    " dans la jungle ou les marais. Friand de champignons, son régime affecte son souffle qui peut être empoisonné" +
                    " ou enflammé selon son habitat."));
            monsterI.insertion(new MonsterActivity(10,"Congalala Emeraude","Pelagus","Asphyxie, Sommeil, Poison, " +
                    "Paralysie, Feu, Explosif", "Glace",2,"Une variété de Congalala à la fourrure verte, " +
                    "à la crête plus imposante. Plus vorace que le Congalala ordinaire, il peut stocker dans son corps une plus grande " +
                    "quantité de gaz, augmentant ainsi ses flatulences s'il est menacé ou provoqué."));
            monsterI.insertion(new MonsterActivity(11,"Lagombi","Pelagus","Glace", "Feu, " +
                    "Foudre",2,"Une bête à crocs qui survit dans les climats froids grâce à sa fourrure chaude " +
                    "et à ses couches épaisses de graisse. Plutôt herbivore, le Lagombi utilise parfois son ouïe et sa capacité à" +
                    " évoluer sur la glace pour attaquer ses proies."));
            monsterI.insertion(new MonsterActivity(12,"Rajang","Pelagus","Foudre", "Glace",
                    6,"Une créature ultra agressive. Peu de chasseurs ont survécu à ses attaques surprenantes." +
                    " Le Rajang est très solitaire et il est difficile de savoir où on peut le chasser."));
            monsterI.insertion(new MonsterActivity(13,"Hermitaur Daimyo","Carapaceon","Eau", "Foudre, " +
                    "Feu", 2,"Ce grand Carapaceon utilise principalement ses pinces et les bulles qu'il produit pour" +
                    " attaquer. si le crâne de monstre qu'il porte sur son dos est détruit, il part immédiatement en quête d'un autre " +
                    "logement."));
            monsterI.insertion(new MonsterActivity(14,"Hermitaur Daimyo prune","Carapaceon","Eau",
                    "Glace, Foudre", 2,"Ce grand Carapaceon est caractérisé par sa couleur et par le " +
                    "crâne de monstre qu'il porte sur son dos. Â la différence des variétés communes, il saute sur ses ennemis, ce " +
                    "qui le rend particulièrement redoutable."));
            monsterI.insertion(new MonsterActivity(15,"Tetsucabra","Amphibien","Tranquilisant",
                    "Eau, Foudre", 2,"Un amphibien aux mâchoires et aux défenses uniques qui filtre les" +
                    " rochers pour trouver des proies. Il se sert de ses puissantes pattes arrière pour traverser des terrains " +
                    "pentus. Sa queue l'aide à bouger mais l'affaiblit en cas de fatigue."));
            monsterI.insertion(new MonsterActivity(16,"Tetsucabra féroce","Amphibien","Explosif",
                    "Glace, Foudre", 2,"Monstre amphibie réputé pour ses marques particulières ressemblant " +
                    "à un visage peint. Comme la variété ordinaire, le Tetsucabra féroce déterre des rochers et les lance, mais ses" +
                    " projectiles explosent à l'impact."));
            monsterI.insertion(new MonsterActivity(17,"Zamtrios","Amphibien","Eau, Glace", "Foudre," +
                    "Feu", 3,"Un amphibien des eaux gelées qui utilise le froid pour étourdir sa proie. Il sécrète" +
                    " un liquide particulier qui protège son corps d'une armure de glace et gèle les ennemis autour de lui. Les " +
                    "grenouilles sont sa nourriture favorite."));
            monsterI.insertion(new MonsterActivity(18,"Zamtrios tigré","Amphibien","Eau, Paralysie",
                    "Glace, Foudre", 3,"À la différence de la variété ordinaire, ce Zamtrios rayé vit" +
                    " principalement dans les zones désertiques. Il peut également gonfler et contracter son corps tout en se " +
                    "déplaçant, ce qui en fait un adversaire d'autant plus redoutable."));
            monsterI.insertion(new MonsterActivity(19,"Grand Jaggi","Wyvern","Aucun","Feu",
                    1,"Un mâle alpha qui dirige les groupes de Jaggi. À l'âge adulte, la plupart des mâles " +
                    "quittent le groupe et reviennent plus tard défier leurs aînés. Le mâle dominant devient un Grand Jaggi. Son " +
                    "cri lui permettrait de donner des ordres complexes."));
            monsterI.insertion(new MonsterActivity(20,"Vélocidrome","Wyvern","Aucun","Glace, Foudre",
                    1,"Un monstre alpha qui dirige les groupes de Velociprey. Plus grand que ses frères avec une " +
                    "crête plus importante, le Velocidrome bondit sur sa proie grâce à ses puissantes pattes arrière et l'immobilise " +
                    "avec ses griffes acérées."));
            monsterI.insertion(new MonsterActivity(21,"Vélocidrome","Wyvern","Paralysie","Foudre, Glace",
                    2,"Un monstre alpha qui dirige les groupes de Genprey. Plus grand que ses frères et doté " +
                    "d'une crête plus importante, le Gendrome utilise le venin contenu dans ses crocs ultra évolués et ses griffes " +
                    "pour paralyser sa proie."));
            monsterI.insertion(new MonsterActivity(22,"Iodrome","Wyvern","Poison","Foudre",
                    2,"Un monstre alpha qui dirige les groupes d'Ioprey. Plus grand que ses frères et pourvu d'une" +
                    " crête plus importante, l'Iodrome crache un poison qui tue lentement sa proie. On le trouve principalement " +
                    "dans les zones subtropicales."));
            monsterI.insertion(new MonsterActivity(23,"Gypceros","Wyvern","Poison, Impact","Feu",
                    2,"Un Wyvern dont la crête proéminente génère des flashs de lumière. Sa peau caoutchouteuse qui" +
                    " résiste aux dommages peut neutraliser les pièges à choc tandis que sa bave contient un venin mortel. Assez " +
                    "timide toutefois."));
            monsterI.insertion(new MonsterActivity(24,"Gypceros améthyste","Wyvern","Poison, Impact",
                    "Feu", 2,"Une variété de Gypceros qui se distingue par sa remarquable couleur " +
                    "violette. Ils sont très résistants au poison et peuvent cracher de grandes quantités de salive extrêmement " +
                    "venimeuse."));
            monsterI.insertion(new MonsterActivity(25,"Yian Kut-Ku","Wyvern","Feu, Impact", "Foudre, Glace"
                    , 1,"Une wyverne en forme d'oiseau avec un grand bec et de grandes oreilles. Le Yian Kut-Ku " +
                    "est vulnérable aux bruits forts. Il est plus petit, mais plus rapide que les autres wyvernes."));
            monsterI.insertion(new MonsterActivity(26,"Yian Kut-Ku bleu","Wyvern","Feu, Impact",
                    "Eau, Foudre", 2,"Une variété de Yian Kut-Ku à la carapace bleue. Comme le Yian " +
                    "Kut-Ku ordinaire, il craint les bruits forts, mais il fait preuve d'une force physique considérablement " +
                    "augmentée lorsqu'il est en colère."));
            monsterI.insertion(new MonsterActivity(27,"Yian Garuga","Wyvern","Feu, Poison, Impact",
                    "Eau", 4,"Une variété de Yian Kut-Ku à la carapace bleue. Comme le Yian " +
                    "Kut-Ku ordinaire, il craint les bruits forts, mais il fait preuve d'une force physique considérablement " +
                    "augmentée lorsqu'il est en colère."));
            monsterI.insertion(new MonsterActivity(28,"Cephadrome","Wyvern","Eau, Paralysie",
                    "Glace, Foudre", 1,"Ce spécimen, à la tête des meutes de Cephalos,est caractérisé par" +
                    " sa grande taille et ses écailles noires robustes. Tout comme ses homologues plus petits, il a une ouïe très fine," +
                    " ce qui le rend sensible au bruit. Ses écailles secrètent une toxine paralysante."));
            monsterI.insertion(new MonsterActivity(29,"Najarala","Wyvern","Paralysie, Impact",
                    "Glace, Eau", 3,"Un monstre qui étourdit sa proie grâce aux vibrations de ses écailles, puis" +
                    " l'enveloppe et l'étouffe. Si un Najarala commence à s'enrouler autour de vous, une évasion rapide ou un meurtre " +
                    "éclair sont vos seules chances de survie."));
            monsterI.insertion(new MonsterActivity(30,"Najarala du déluge","Wyvern","Eau, Paralysie",
                    "Feu, Foudre", 3,"Cette Sous-Espèce de Najarala utilise son long corps comme Arme Mortelle." +
                    " Quand il est menacé, le Najarala du Déluge Crache une Substance aqueuse sur ses cibles,utilisant parfois ses " +
                    "écailles pour diriger le jet et atteindre des proies rapides."));
            monsterI.insertion(new MonsterActivity(31,"Khezu","Wyvern","Foudre, Paralysie", "Feu",
                    3,"Une wyverne répugnante vivant dans les grottes et autres lieux sombres. Presque aveugle, le " +
                    "Khezu chasse à l'odeur et utilise des décharges électriques pour paralyser sa proie avant de bondir depuis les " +
                    "hauts plafonds et parois."));
            monsterI.insertion(new MonsterActivity(32,"Khezu grenat","Wyvern","Foudre, Paralysie", "Eau",
                    3,"Une effrayante variété de Khezu écarlate au tempérament plus agressif. Ses organes électriques" +
                    " sont également plus développés, lui permettant une plus grande variété d'attaques pour immobiliser et piéger ses" +
                    " proies."));
            monsterI.insertion(new MonsterActivity(33,"Basarios","Wyvern","Feu, Poison, Sommeil", "Dragon," +
                    "Eau", 2,"Ces jeunes Gravios sont connus pour leur carapace très dure. Souvent cachés sous terre, ils" +
                    " imitent les rochers et attaquent les mineurs peu méfiants. On dit qu'ils émettent des gaz toxiques et sont vulnérables" +
                    " en particulier aux bombes."));
            monsterI.insertion(new MonsterActivity(34,"Basarios rubis","Wyvern","Feu, Poison, impact, Sommeil",
                    "Glace", 2,"Une variété de Basarios qui disperse les cristaux de son dos pour repousser " +
                    "les attaquants, offrant une chance de récolter des minéraux rares. Sautez sur l'un d'eux quand sa carapace est " +
                    "cassée pour le retourner et exposer son ventre vulnérable."));
            monsterI.insertion(new MonsterActivity(35,"Gravios","Wyvern","Feu, Sommeil, Poison", "Eau",
                    3,"Grand dragon volant qui vit dans les régions volcaniques. Possède un souffle puissant à haute " +
                    "température qui lui permet d'évacuer les gaz chauds qui sommeillent dans son corps. Sa coque extérieure est très" +
                    " dure mais si elle est brisée, le monstre est d'une fragilité insoupçonnée."));
            monsterI.insertion(new MonsterActivity(36,"Gravios onyx","Wyvern","Feu, Sommeil", "Eau",
                    4,"Une sous-espèce de Gravios qui se distingue par une carapace dure et noire pouvant contenir la" +
                    " température corporelle très élevé de la créature. Celle-ci décharge parfois cette énergie thermique sous forme de" +
                    " rayon de chaleur très puissant."));
            monsterI.insertion(new MonsterActivity(37,"Rathian","Wyvern","Feu, Poison", "Dragon, Foudre",
                    2,"Une wyverne femelle crachant du feu qu'on appelle aussi \"Reine de la terre\". Pourvue de pattes " +
                    "puissantes et d'une queue sécrétant du poison, elle chasse surtout au sol. Les Rathians chassent parfois en " +
                    "collaboration avec les Rathalos."));
            monsterI.insertion(new MonsterActivity(38,"Rathian sakura","Wyvern","Feu, Poison", "Dragon, Foudre",
                    3,"Une sous-espèce de Rathian aux écailles rose vif. Les Rathians sakura manient leur queue toxique plus " +
                    "adroitement que les Rathians ordinaires et utilisent une grande variété d'attaques pour affaiblir leur proie avant de la" +
                    " mettre à mort."));
            monsterI.insertion(new MonsterActivity(39,"Rathian dorée","Wyvern","Feu, Poison", "Foudre, Eau",
                    6,"Une variété rare de Rathian dont le joli corps doré rappelle la lune. On sait peu de choses sur son " +
                    "comportement ou sa physiologie, et notamment sur la source de cette éclatante couleur dorée."));
            monsterI.insertion(new MonsterActivity(40,"Rathalos","Wyvern","Feu, Poison, Impact", "Dragon, Foudre",
                    3,"Terrible wyverne surnommée 'roi des cieux'. Comme la Rathian, il surveille de vastes territoires autour de" +
                    " son nid et fond du ciel sur les intrus, attaquant avec ses griffes empoisonnées et son souffle de feu."));
            monsterI.insertion(new MonsterActivity(41,"Rathalos azur","Wyvern","Feu, Poison, Impact", "Dragon, Glace",
                    4,"Une sous-espèce de Rathalos couleur azur. Plus agiles que leurs cousins ordinaires, ils localisent leur" +
                    " proie depuis le ciel et foncent sur elle en un éclair pour la tuer. Dès que ce redoutable chasseur a choisi sa proie, " +
                    "celle-ci est perdue."));
            monsterI.insertion(new MonsterActivity(42,"Rathalos argenté","Wyvern","Feu, Poison, Impact", "Eau," +
                    " Foudre", 6,"Une variété rare de Rathalos au joli corps argenté rappelant le soleil. On sait peu de choses " +
                    "sur son comportement ou sa physiologie, et notamment sur la source de cette éclatante couleur argentée."));
            monsterI.insertion(new MonsterActivity(43,"Tigrex","Wyvern","Aucun", "Foudre, Dragon",
                    4,"Un wyvern volant aux origines primitives évidentes. Enclin à la violence, le Tigrex fait preuve d'une " +
                    "terrible férocité avec ses griffes, ses mâchoires et ses membres développés Il occupe une grande zone qui court jusqu'à " +
                    "l'Étendue gelée."));
            monsterI.insertion(new MonsterActivity(44,"Tigrex berserk","Wyvern","Impact", "Eau",
                    5,"Une sous-espèce de Tigrex aussi brutale que vorace. Bien qu'il préfère les régions volcaniques, on le " +
                    "trouve dans des zones diverses. Ses cris, plus perçants que ceux du Tigrex ordinaire, envoient des ondes de choc " +
                    "longue portée."));
            monsterI.insertion(new MonsterActivity(45,"Tigrex magma","Wyvern","Explosif", "Eau, Glace",
                    6,"Une variété de Tigrex rare dont l'existence a été déduite d'après la découverte de marques" +
                    " de griffes et d'empreintes plus grandes que celles du Tigrex ordinaire. Sans observation confirmée, son " +
                    "existence fait débat parmi les chasseurs."));
            monsterI.insertion(new MonsterActivity(46,"Seregios","Wyvern","Lacération", "Foudre, Glace",
                    5,"Ce wyvern discrète n'a été vue que rarement ces dernières années. Elle est capable de lancer" +
                    " ses écailles tranchantes sur sa proie ou de les dresser pour frapper ceux qui la menacent."));
            monsterI.insertion(new MonsterActivity(47,"Monoblos","Wyvern","Aucun", "Foudre, Glace",
                    3,"Ce wyvern du désert creuse rapidement le sable. Son unique corne lui permet d'effectuer des " +
                    "charges mortelles. Bien qu'elle ne dispose d'aucune attaque de souffle, son rugissement est capable de percer le " +
                    "tympan humain."));
            monsterI.insertion(new MonsterActivity(48,"Monoblos ivoire","Wyvern","Aucun", "Foudre",
                    4,"Cette sous-espèce de Monoblos rare est couverte de plaques blanchâtres. Plus féroce que son " +
                    "homologue ordinaire, le Monoblos ivoire n'abandonne jamais la proie qu'il a choisie."));
            monsterI.insertion(new MonsterActivity(49,"Diablos","Wyvern","Aucun", "Glace",
                    4,"Cette wyverne du désert tient son nom des cornes gigantesques qui la couronnent. Tout " +
                    "comme le Monoblos, le Diablos charge ses proies ou jaillit du sol. Il devient plus rapide quand il est énervé." +
                    " Ses oreilles sensibles le rendent vulnérable aux bombes soniques."));
            monsterI.insertion(new MonsterActivity(50,"Diablos noire","Wyvern","Aucun", "Glace",
                    5,"Ce Diablos à carapace noire est considéré comme une sous-espèce, mais il s'agit seuement " +
                    "d'une femelle Diablos en chaleur. Très agressive en période de reproduction, sa couleur sert d'avertissement " +
                    "pour les autres créatures."));
            monsterI.insertion(new MonsterActivity(51,"Akantor","Wyvern","Feu, Acide, Dragon", "Dragon," +
                    "Foudre", 7,"Un wyvern entouré de mystère portant divers nom: parfois appelée \"Dieu noir\" ou" +
                    " \"Tyran de feu\", la créature est nommée \"Akantor\" par la guilde. Ses épines dorsales et ses défenses géantes " +
                    "en font une terrifiante bête des zones volcaniques."));
            monsterI.insertion(new MonsterActivity(52,"Ukanlos","Wyvern","Glace, Immobilisation", "Feu",
                    7,"Ce wyvern énigmatique n'est présent que dans les contrés les plus reculées. Ses mâchoires sont" +
                    " capables de broyer la glace comme la pierre. Les natif des régions qu'il habite affirment que son apparence est " +
                    "identique à celle de leur dieu blanc."));
            monsterI.insertion(new MonsterActivity(53,"Zinogre","Wyvern","Foudre", "Glace, Eau",
                    3,"Un wyvern à crocs au corps chargé d'électricité, prospérant dans les terrains montagneux" +
                    " grâce à ses griffes acérées et ses membres solides. Pour chasser, il rassemble un grand nombre de foudrinsectes" +
                    " et entre dans un état de supercharge."));
            monsterI.insertion(new MonsterActivity(54,"Zinogre stygien","Wyvern","Dragon", "Foudre, Eau",
                    5,"Une sous-espèce de Zinogre au corps noir. Il rassemble des insectes se nourrissant de " +
                    "baies-dragons et utilise leur énergie dragon élémentaire pour gagner en puissance. C'est peut-être ce qui lui" +
                    " permet de survivre aux climats extrêmes."));
            monsterI.insertion(new MonsterActivity(55,"Brachydios","Wyvern","Explosif", "Eau",
                    5,"Un Wyvern de terre recouvert d'une substance verte explosive. On pense que cette moisissure" +
                    " gluante explose en réaction à un élément de la salive du monstre. Ce dernier peut également donner de puissants" +
                    " coups avec ses pattes avant."));
            monsterI.insertion(new MonsterActivity(56,"Deviljho","Wyvern","Acide, Dragon", "Dragon," +
                    "Foudre", 6,"Les redoutables Deviljho nomades n'ont pas de territoire défini. Leurs muscles gonflent" +
                    " lorsqu'on les provoque, révélant des blessures anciennes. Ils doivent se nourrir sans arrêt à cause de leur " +
                    "chaleur corporelle, mettant en danger les autres espèces."));
            monsterI.insertion(new MonsterActivity(57,"Kirin","Dragon","Foudre, Paralysie", "Feu," +
                    "Eau", 5,"Un dragon ancien si rare qu'on en sait très peu sur son mode de vie, même si tout le" +
                    " monde connaît la grande valeur des morceaux de Kirin. On dit qu'il ne fait qu'un avec la foudre et que son corps" +
                    " s'enveloppe d'électricité quand on le provoque."));
            monsterI.insertion(new MonsterActivity(58,"Kirin Oroshi","Dragon","Glace", "Feu, Eau",
                    5,"Peu de témoignages fiables attestent de l'existence de ces créatures furtives. Selon les " +
                    "rares rapports disponibles, la température chute lorsqu'elles apparaissent et l'humidité de l'air gèle " +
                    "spontanément."));
            monsterI.insertion(new MonsterActivity(59,"Gore Magala","Dragon","Infection", "Feu, Foudre" +
                    "Dragon", 5,"Un monstre curieux qui, en cas de menace, répand une substance semblable à du pollen " +
                    "pour intensifier ses sens tout en produisant des effets néfastes sur les créatures qui l'inhalent. Il est aussi " +
                    "furtif que mystérieux."));
            monsterI.insertion(new MonsterActivity(60,"Shagaru Magala","Dragon","Infection", "Dragon, Feu",
                    6,"La lumière éclatante typique de ce Gore Magala adulte a été aperçue dans le Sanctuaire du Mont" +
                    " céleste. Certains pensent que Shagaru Magala fut le \"vent putride qui fit flétrir une montagne\", une calamité " +
                    "décrite dans les textes anciens."));
            monsterI.insertion(new MonsterActivity(61,"Kushala Daora","Dragon","Dragon, Glace", "Dragon, " +
                    "Foudre", 6,"Il est difficile d'approcher un de ces dragons métalliques, mais certains affirment que" +
                    " c'est possible si la créature est affaiblie par le poison ou si elle a un autre chasseur sur son dos, limitant la " +
                    "pression du vent qu'elle peut rassembler."));
            monsterI.insertion(new MonsterActivity(62,"Teostra","Dragon","Feu, Explosif, Dragon", "Dragon, " +
                    "Eau", 6,"Un dragon brutal enveloppé de flammes et crachant du feu. Les Teostra sont d'une nature si féroce" +
                    " et meurtrière que la guilde surveille leurs déplacements autant que possible."));
            monsterI.insertion(new MonsterActivity(63,"Chameleos","Dragon","Poison, Dragon, Tranquilisant, Acide",
                    "Dragon, Feu", 6,"Les très rares signalements de ce dragon suggèrent qu'il est capable de " +
                    "se fondre dans son environnement comme un caméléon, d’où son nom. On dit qu'il peut attaquer de n'importe où, mais" +
                    " que les bombes fumigènes le rendent visible."));
            monsterI.insertion(new MonsterActivity(64,"Fatalis noir","Dragon","Feu, Dragon, Explosif", "Dragon",
                    7,"Les histoires sur ce dragon légendaire remontent à l'antiquité. Beaucoup de chasseurs expérimentés ont" +
                    " cherché à le défier, mais aucun n'est jamais revenu. Ce monstre est enveloppé de mystère..."));
            monsterI.insertion(new MonsterActivity(65,"Fatalis pourpre","Dragon","Explosif, Feu, Dragon", "Dragon, Glace",
                    7,"Les histoires sur ce dragon légendaire remontent à l'antiquité. Beaucoup de chasseurs expérimentés ont" +
                    " cherché à le défier, mais aucun n'est jamais revenu. Ce monstre est enveloppé de mystère..."));
            monsterI.insertion(new MonsterActivity(66,"Fatalis blanc","Dragon","Dragon, Foudre", "Dragon, Feu",
                    7,"Les histoires sur ce dragon légendaire remontent à l'antiquité. Beaucoup de chasseurs expérimentés ont" +
                    " cherché à le défier, mais aucun n'est jamais revenu. Ce monstre est enveloppé de mystère..."));
            monsterI.insertion(new MonsterActivity(67,"Gogmazios","Dragon","Pétrole, Feu", "Dragon, Feu",
                    7,"Cet énorme dragon couvert d'un fluide épais et collant ne semble pas gêné par l'épieu tueur de dragon" +
                    " planté dans son dos. Malgré sa taille, on dit que ce béhémoth mystérieux est capable de voler."));
            monsterI.insertion(new MonsterActivity(67,"Dah'ren Mohran","Dragon","Aucun", "Foudre, Dragon",
                    6,"Un énorme dragon ancien qui parcourt le Grand Désert, détruisant les obstacles avec ses cornes en " +
                    "spirale. Sa couleur provient de l'épaisse couche de métaux oxydés et d'autres minéraux rares qui se logent dans sa peau."));
            monsterI.insertion(new MonsterActivity(67,"Dalamadur","Dragon","Paralysie", "Dragon",
                    7,"Un énorme dragon ancien, dont la taille dépasse l'entendement humain. Seuls les contes de fées mentionnent" +
                    " son existence. On dit qu'il peut envelopper la surface du monde et soulever des montagnes d'un simple tressaillement."));
            return null;
        }
    }
}
