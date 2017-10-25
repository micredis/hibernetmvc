USE `test`;
DROP TABLE IF EXISTS `Book`;
CREATE TABLE `Book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `author` varchar(100) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `isbn` varchar(20) DEFAULT NULL,
  `readAlready` bit(1) DEFAULT 0,
  `title` varchar(100) DEFAULT NULL,
  `printYear` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `Book` (`author`, `description`, `isbn`, `title`, `printYear`)
VALUES
('Allen B. Downey','Think Java is an introduction to Java programming for beginners. It is tailored for students preparing for the Computer Science Advanced Placement (AP) Exam, but it is for anyone who wants to learn Java.','978-1491929568','Think Java',2016),
('Bruce Eckel','From the fundamentals of Java syntax to its most advanced features, Thinking in Java is designed to teach, one simple step at a time.','978-0131872486','Thinking in Java',2006),
('Joshua J. Bloch','Bloch explores new design patterns and language idioms, showing you how to make the most of features ranging from generics to enums, annotations to autoboxing.','978-0321356680','Effective Java',2008),
('Robert C. Martin','Martin has teamed up with his colleagues from Object Mentor to distill their best agile practice of cleaning code on the fly into a book that will instill within you the values of a software craftsman and make you a better programmer.','978-0132350884','Clean Code',2008),
('Kathy Sierra, Bert Bates','If you want to understand Java, this book is for you.','978-0596009205','Head First Java',2005),
('Brian Goet, Tim Peierls, Joshua Bloch et al.','This is the book you need if you are writing--or designing, or debugging, or maintaining, or contemplating--multithreaded Java programs.','978-0321349606','Java Concurrency in Practice',2006),
('Cay S. Horstmann','Rewritten and reorganized to illuminate new Java SE 8 features, idioms, and best practices, it contains hundreds of example programs—all carefully crafted for easy understanding and practical applicability.','978-0134177304','Core Java Volume I--Fundamentals',2016),
('Eric Freeman, Bert Bates et al.','It is an intelligent and well thought-out discussion of Java design patterns, and if you dont know what a design pattern is then this is an excellent way to find out.','978-0596007126','Head First Design Patterns',2004),
('Herbert Schildt','Bestselling programming author Herb Schildt covers the entire Java language, including its syntax, keywords, and fundamental programming principles.','978-0071808552','Java: The Complete Reference',2014),
('Robert Sedgewick, Kevin Wayne','This book surveys the most important computer algorithms currently in use and provides a full treatment of data structures and algorithms for sorting, searching, graph processing, and string processing.','978-0321573513','Algorithms',2011),
('Cay S. Horstmann','Rewritten and reorganized to illuminate powerful new Java features, idioms, and best practices for enterprise and desktop development, this book contains hundreds of up-to-date example programs.','978-0134177298','Core Java, Volume II--Advanced Features',2016),
('Erich Gamma, Richard Helm et al.','Design Patterns is a modern classic in the literature of object-oriented development, offering timeless and elegant solutions to common problems in software design.','978-0201633610','Design Patterns: Elements of Reusable Object-Oriented Software',1994),
('Raoul-Gabriel Urma et al.','Java 8 in Action is a clearly written guide to the new features of Java 8.','978-1617291999','Java 8 in Action: Lambdas, Streams, and functional-style programming',2014),
('Craig Walls','This book covers the latest features, tools, and practices including Spring MVC, REST, Security, Web Flow, and more.','978-1617291203','Spring in Action: Covers Spring 4',2014),
('David Harris, Sarah Harris','Beginning with digital logic gates and progressing to the design of combinational and sequential circuits, the book uses these fundamental building blocks as the basis for the design of an actual MIPS processor.','978-0123944245','Digital Design and Computer Architecture',2012),
('Robert Lafore','In 2nd edition, the program is rewritten to improve operation and clarify the algorithms, the example programs are revised, and questions and exercises will be added at the end of each chapter.','978-0672324536','Data Structures and Algorithms in Java',2002),
('Jon Bentley','Illustrated by programs designed as much for fun as for instruction, the book is filled with lucid and witty descriptions of practical programming techniques and fundamental design principles.','978-0201657883','Programming Pearls',1999),
('Brett D. McLaughlin, Gary Pollice, Dave West','This book shows you how to analyze, design, and write serious object-oriented software: software that is easy to reuse, maintain, and extend.','978-0596008673','Head First Object-Oriented Analysis and Design',2006),
('Steve McConnell','This book illustrates the art and science of software construction.','978-0735619678','Code Complete: A Practical Handbook of Software Construction',2004),
('Martin Fowler et al.','With its clear advice on a hot new topic, Refactoring is sure to be essential reading for anyone who writes or maintains object-oriented software.','978-0201485677','Refactoring: Improving the Design of Existing Code',1999),
('Кэти Сиерра, Берт Бейтс','Прочитав книгу вы освоите все самое нужное: синтаксис и концепции языка, работу с потоками, работу в сети, распределенное программирование. Вся теория закрепляется интереснейшими примерами и тестами.','978-5-699-54574-2','Изучаем Java',2017);