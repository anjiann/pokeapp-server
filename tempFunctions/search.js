const arr = [];

async function searchPokemon(e){
    e.preventDefault();

    let input = document.getElementById("search-input").value

    for (let i = 0; i <= arr.length; i++){
        let table = document.getElementById("pokemonTable");
        let row = table.insertRow(i+1);
        let cell1 = row.insertCell(0);
        let cell2 = row.insertCell(1);

        //console.log(data.results[x].name;

        let tmp = arr[i].startsWith(input);

        if (tmp){


            cell1.innerHTML = i;
            cell2.innerHTML = arr[i];
            console.log(arr[i]);
        }
    }

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
        arr.push(data.results[i].name);
    }

    console.log("All pokemon saved in array");

}

document.getElementsByTagName("form")[0].addEventListener('submit', searchPokemon)
document.onload = getAllPokemon();