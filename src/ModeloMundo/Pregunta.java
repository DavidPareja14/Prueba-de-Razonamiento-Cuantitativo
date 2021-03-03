/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloMundo;

/**
 *
 * @author USUARIO
 */
public class Pregunta {
    
    private String pregunta;
    private String rutaImagenInformacion;
    private String[] opciones;
    private String respuestaCorrecta;
    private boolean respondioBien;
    private String rutaImagenPregunta;
    
    public Pregunta(String pPregunta, String pRutaImagenInformacion, String[] pOpciones, String pRutaImagenPregunta, String pRespuestaCorrecta)
    {
        pregunta = pPregunta;
        rutaImagenInformacion = pRutaImagenInformacion;
        opciones = pOpciones;
        respuestaCorrecta = pRespuestaCorrecta;
        respondioBien = false;
        rutaImagenPregunta = pRutaImagenPregunta;
    }
    
    public void setRespondioBien(boolean pRespondioBien)
    {
        respondioBien = pRespondioBien;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String getRutaImagenInformacion() {
        return rutaImagenInformacion;
    }

    public String[] getOpciones() {
        return opciones;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public boolean isRespondioBien() {
        return respondioBien;
    }

    public String getRutaImagenPregunta() {
        return rutaImagenPregunta;
    }
    
}
