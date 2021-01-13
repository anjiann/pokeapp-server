const pokemons = [];

function searchPokemon(e){
    e.preventDefault();
    
    let result = [];

    //remove these things when incorporating it into project since this is just to display things and make sure it works
    let input = document.getElementById("search-input").value;

    for (let i = 0; i <= pokemons.length - 1; i++){
        //remove this chunk as well
        let table = document.getElementById("pokemonTable");
        let row = table.insertRow(i+1);
        let cell1 = row.insertCell(0);
        let cell2 = row.insertCell(1);

        let tmp = pokemons[i].startsWith(input);

        if (tmp){

            //remove this chunk as well
            cell1.innerHTML = i;
            cell2.innerHTML = pokemons[i];


            //remove this console log for the final part as well
            //console.log(pokemons[i]);

            result.push(pokemons[i]);
        }
    }

    console.log(result);
    return result;

}

async function getAllPokemon(){
	let res = await fetch("https://pokeapi.co/api/v2/pokemon?offset=0&limit=1118",{ 
				method: "GET",
				headers:{
					"Content-Type": "application/json"
				}
    });

    const data = await res.json();
    
    for (let i = 0; i <= data.results.length - 1; i++){
        pokemons.push(data.results[i].name);
    }

    console.log("All pokemon saved in array");

}


//change this line based on the design of the html page
document.getElementsByTagName("form")[0].addEventListener('submit', searchPokemon);


document.onload = getAllPokemon();