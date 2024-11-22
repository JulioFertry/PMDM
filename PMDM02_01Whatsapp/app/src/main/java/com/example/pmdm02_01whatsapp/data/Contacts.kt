package com.example.pmdm02_01whatsapp.data

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.pmdm02_01whatsapp.R
import com.example.pmdm02_01whatsapp.model.Contact
import com.example.pmdm02_01whatsapp.model.Message


@Composable
fun getContacts():List<Contact> {
    val contactList = listOf(

        Contact(
            "01",
            painterResource(id = R.drawable.aa_2dam),
            stringResource(id = R.string.contact1_name),
            mutableListOf(
                Message("Como se centra un div?", "01:25", false),
                Message("Aún no lo ha explicado la de empresa", "02:43", true),
                Message("joe", "03:18", false)
            )
        ),
        Contact(
            "02",
            painterResource(id = R.drawable.aa_eustaquio),
            stringResource(id = R.string.contact2_name),
            mutableListOf(
                Message("Me debes dinero", "11:34", false),
                Message("Te compré un kebab, pagame", "11:56", false),
                Message("Hazme bizum ya, lo necesito", "12:10", false)
            )
        ),
        Contact(
            "03",
            painterResource(id = R.drawable.aa_novia2),
            stringResource(id = R.string.contact2_name),
            mutableListOf(
                Message("Tienes otra novia?", "12:34", false),
                Message("No", "14:25", true),
                Message("Estoy embarazada", "14:25", false),
                Message("No puedo ver los mensajes, algo falla", "14:26", true),
                Message("Por cierto me ha salido trabajo fuera del país", "14:26", true)
            )
        ),
        Contact(
            "04",
            painterResource(id = R.drawable.aa_doctor),
            stringResource(id = R.string.contact4_name),
            mutableListOf(
                Message("Malas noticias, es usted infértil", "14:25", false)
            )
        ),
        Contact(
            "05",
            painterResource(id = R.drawable.aa_anacleto),
            stringResource(id = R.string.contact5_name),
            mutableListOf(
                Message("Creo que voy a ser papá", "14:27", false)
            )
        ),
        Contact(
            "06",
            painterResource(id = R.drawable.aa_novia1),
            stringResource(id = R.string.contact6_name),
            mutableListOf(
                Message("Me has puesto los cuernos?!?", "14:27", false),
                Message("No!", "14:27", true),
                Message("Con la novia de anacleto!?!", "14:28", false),
                Message("Ah si", "14:28", true)
            )
        ),
        Contact(
            "07",
            painterResource(id = R.drawable.aa_mono),
            stringResource(id = R.string.contact7_name),
            mutableListOf(
                Message("Me voy a Mexico, vienes?", "14:29", true),
                Message("Ya tengo el tequila, a que hora salimos?", "14:32", false)
            )
        ),
        Contact(
            "08",
            painterResource(id = R.drawable.aa_mama),
            stringResource(id = R.string.contact8_name),
            mutableListOf(
                Message("Necesito 200 euros", "14:54", true),
                Message("Para que quieres tanto dinero?", "14:58", false),
                Message("Para estudiar", "14:58", true)
            )
        ),
        Contact(
            "09",
            painterResource(id = R.drawable.aa_aeropuerto),
            stringResource(id = R.string.contact9_name),
            mutableListOf(
                Message("Cuanto por 2 billetes a Mexico?", "14:35", true),
                Message("200 pavos sosio", "14:35", false)
            )
        ),
        Contact(
            "10",
            painterResource(id = R.drawable.aa_papa),
            stringResource(id = R.string.contact10_name),
            mutableListOf(
                Message("He comprado todos los billetes a Mexico para que no huyas", "15:03", false)
            )
        ),
        Contact(
            "11",
            painterResource(id = R.drawable.aa_profesor),
            stringResource(id = R.string.contact11_name),
            mutableListOf(
                Message("Entrega el whatsapp", "16:28", false),
                Message("Tengo el cuello roto y estoy en Mexico", "16:30", true),
                Message("11 puntos menos", "16:34", false)
            )
        ),
        Contact(
            "12",
            painterResource(id = R.drawable.aa_juanmecanico),
            stringResource(id = R.string.contact12_name),
            mutableListOf(
                Message("*Mensaje eliminado*", "00:31", false),
                Message("*Mensaje eliminado*", "00:32", true),
                Message("*Mensaje eliminado*", "00:32", false),
                Message("*Mensaje eliminado*", "00:32", false),
                Message("*Mensaje eliminado*", "00:33", true),
                Message("*Mensaje eliminado*", "00:33", false),
                Message("*Mensaje eliminado*", "00:35", true),
                Message("*Mensaje eliminado*", "00:35", true),
                Message("*Mensaje eliminado*", "00:35", true),
                Message("*Mensaje eliminado*", "00:36", true),
                Message("*Mensaje eliminado*", "00:39", false),
                Message("*Mensaje eliminado*", "00:39", false),
                Message("*Mensaje eliminado*", "00:43", true),
                Message("*Mensaje eliminado*", "00:43", false),
                Message("*Mensaje eliminado*", "00:43", false),
                Message("*Mensaje eliminado*", "00:50", true),
                Message("*Mensaje eliminado*", "00:51", false),
                Message("*Mensaje eliminado*", "00:53", false),
                Message("*Mensaje eliminado*", "01:01", true),
                Message("*Mensaje eliminado*", "01:07", true),
                Message("*Mensaje eliminado*", "01:07", false)
            )
        )

    )

    return contactList
}