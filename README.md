AVISOS 
- no toqueis ninguna rama que se llame Master o Main

Yo me encargo de juntarlo vosotros solo haceis 
- teneis que hacer el pull para cogerlo
- vuestra rama y los commits en esta 
- push para llevarlo al repositorio cuando acabeis 

TUTORIAL 

1º HACER UN clone

// Vamos a sacar del repositorio online:
git clone https://github.com/rgxkokimoto/ProyecoAndroid.git

2º Crear vuestra rama EN EL PROYECTO NO CREIS OTRO NUEVO.

// usar este comando os lleva y crea directamente la rama ponerlo con este formato "RAMA-NOMBRE"
git checkout -b "RAMA-NOMBRE"

para ver las ramas
'''
git Branch 
'''

si no esta tu rama puede ser que solo esten en remotas haz 
```
git branch -r
```

te aparecerá algo como esto
```
origin/main
origin/RAMA-ALEX
```

ahora muévete a TU rama usando este comando
```
git checkout -b RAMA-ALEX origin/RAMA-ALEX
```

// comando para moverse de rama no pongas el -b 
git checkout "RAMA-NOMBRE"

// Cuando hagas modificaciones y quieras guardarlo haz esto dos comandos 
git add .
git commit -m "Descripción de los cambios"
git push origin nombre_rama // este es para subirlo al repositorio online esta bien que lo hagais por si perdeis datos 


// ESTA PARTE ES PARA MI NO HAGAS ESTOS COMANDOS 
