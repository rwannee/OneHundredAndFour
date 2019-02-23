package onehundredandfour;

/**
 * Cards implementation of Card.
 */
public enum Cards implements Card {
	C1 (1, 1),
	C2 (2, 1),
	C3 (3, 1),
	C4 (4, 1), 
	C5 (5, 2),
	C6 (6, 1),
	C7 (7, 1),
	C8 (8, 1),
	C9 (9, 1),
	C10 (10, 3),
	C11 (11, 5),
	C12 (12, 1),
	C13 (13, 1), 
	C14 (14, 2),
	C15 (15, 2),
	C16 (16, 1),
	C17 (17, 1),
	C18 (18, 1),
	C19 (19, 1),
	C20 (20, 3),
	C21 (21, 1),
	C22 (22, 5),
	C23 (23, 1), 
	C24 (24, 1),
	C25 (25, 2),
	C26 (26, 1),
	C27 (27, 1),
	C28 (28, 1),
	C29 (29, 1),
	C30 (30, 3),
	C31 (31, 1),
	C32 (32, 1),
	C33 (33, 5),
	C34 (34, 1),
	C35 (35, 2),
	C36 (36, 1),
	C37 (37, 1),
	C38 (38, 1),
	C39 (39, 1),
	C40 (40, 3),
	C41 (41, 1),
	C42 (42, 1),
	C43 (43, 1),
	C44 (44, 5),
	C45 (45, 2),
	C46 (46, 1),
	C47 (47, 1),
	C48 (48, 1),
	C49 (49, 1),
	C50 (50, 3),
	C51 (51, 1),
	C52 (52, 1),
	C53 (53, 1),
	C54 (54, 1),
	C55 (55, 7),
	C56 (56, 1),
	C57 (57, 1),
	C58 (58, 1),
	C59 (59, 1),
	C60 (60, 3),
	C61 (61, 1),
	C62 (62, 1),
	C63 (63, 1),
	C64 (64, 1),
	C65 (65, 2),
	C66 (66, 5),
	C67 (67, 1),
	C68 (68, 1),
	C69 (69, 1),
	C70 (70, 3),
	C71 (71, 1),
	C72 (72, 1),
	C73 (73, 1),
	C74 (74, 1),
	C75 (75, 2),
	C76 (76, 1),
	C77 (77, 5),
	C78 (78, 1),
	C79 (79, 1),
	C80 (80, 3),
	C81 (81, 1),
	C82 (82, 1),
	C83 (83, 1),
	C84 (84, 1),
	C85 (85, 2),
	C86 (86, 1),
	C87 (87, 1),
	C88 (88, 5),
	C89 (89, 1),
	C90 (90, 3),
	C91 (91, 1),
	C92 (92, 1),
	C93 (93, 1),
	C94 (94, 1),
	C95 (95, 2),
	C96 (96, 1),
	C97 (97, 1),
	C98 (98, 1),
	C99 (99, 5),
	C100 (100, 3),
	C101 (101, 1),
	C102 (102, 1),
	C103 (103, 1),
	C104 (104, 1)
	;

	int faceValue;
	int score;

	/**
	 * Cards constructor.
	 * 
	 * @param faceValue is the value of the card.
	 * @param score is the score that the card holds.
	 * @return the Cards.
	 * 
	 */
	Cards(int faceValue, int score) {
        this.faceValue = faceValue;
        this.score = score;
    }

	@Override
	public int getValue() {
		return this.faceValue;
	}

	@Override
	public int getScore() {
		return this.score;
	}
}
