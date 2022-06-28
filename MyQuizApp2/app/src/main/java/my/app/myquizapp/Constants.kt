package my.app.myquizapp

object Constants {
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_Question"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): List<Question> {

        val questionsList = ArrayList<Question>()
        val que1 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina", "Australia",
            "Armenia", "Austria", 1
        )
        questionsList.add(que1)

        // 2
        val que2 = Question(
            2, "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Angola", "Austria",
            "Australia", "Armenia", 3
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
            3, "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Belarus", "Belize",
            "Brunei", "Brazil", 4
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
            4, "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Bahamas", "Belgium",
            "Barbados", "Belize", 2
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
            5, "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Gabon", "France",
            "Fiji", "Finland", 3
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
            6, "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany", "Georgia",
            "Greece", "none of these", 1
        )

        questionsList.add(que6)

        // 7
        val que7 = Question(
            7, "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Dominica", "Egypt",
            "Denmark", "Ethiopia", 3
        )

        questionsList.add(que7)

        // 8
        val que8 = Question(
            8, "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Ireland", "Iran",
            "Hungary", "India", 4
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
            9, "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Australia", "New Zealand",
            "Tuvalu", "United States of America", 2
        )
        questionsList.add(que9)

        // 10
        val que10 = Question(
            10, "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait", "Jordan",
            "Sudan", "Palestine", 1
        )
        questionsList.add(que10)

        val que11 = Question(
            11, "What is the name of this world-known tourist destination in Italy?",
            R.drawable.ic_leaning_tower_of_pisa,
            "Ponte Vecchio", "Leaning Tower of Pisa",
            "Milan Cathedral", "Qutub Minar", 2
        )
        questionsList.add(que11)
        val que12 = Question(
            12, "From which country did this musical instrument originally come from?",
            R.drawable.ic_guitar,
            "Spain", "Germany",
            "France", "Austria", 1
        )
        questionsList.add(que12)
        val que13 = Question(
            13, "In which year did the British passenger liner Titanic sink in the" +
                    " North Atlantic Ocean, which made more than 1,500 people die?",
            R.drawable.ic_titanic,
            "1901", "1912",
            "1923", "1999", 2
        )
        questionsList.add(que13)
        val que14 = Question(
            14, "This picture reminds you of which famous movie series?",
            R.drawable.ic_harry_potter,
            "Pirates Of the Caribbean", "Lord Of the Ring",
            "Harry Potter", "Final Fantasy 7", 3
        )
        questionsList.add(que14)
        val que15 = Question(
            15, "What is the name of this Pokemon?",
            R.drawable.ic_pikachu,
            "Charizard", "Pikachu",
            "MewTwo", "Squirtle", 2
        )
        questionsList.add(que15)
        val que16 = Question(
            16, "What is the name of this extinct flightless bird, " +
                    "which was endemic to the island of Mauritius in the Indian Ocean?",
            R.drawable.ic_dodo,
            "Toto", "Momo",
            "Dodo", "KhoKho", 3
        )
        questionsList.add(que16)
        val que17 = Question(
            17, "How high is the Burj Khalifa in Dubai, United Arab Emirates?",
            R.drawable.ic_burj_khalifa,
            "830 meters", "960 meters",
            "1060 meters", "1070 meters", 1
        )
        questionsList.add(que17)
        val que18 = Question(
            18, "What is the name of this cryptocurrency or decentralised digital" +
                    " currency, which was invented in 2009 by Satoshi Nakamoto?",
            R.drawable.ic_crypto,
            "Ethereum", "Bitcoin",
            "XRP", "Doegcoin", 2
        )
        questionsList.add(que18)
        val numberOfElements = 7
        return questionsList.asSequence().shuffled().take(numberOfElements).toList()
    }
}