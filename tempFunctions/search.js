async function searchPokemon(e){
    e.preventDefault();

	let res = await fetch("https://pokeapi.co/api/v2/pokemon?offset=0&limit=1118",{ 
				method: "GET",
				headers:{
					"Content-Type": "application/json"
				}
	});

    const data = await res.json();
    //console.log(data.results.name);
    console.log(data.results[1].name);


    let x = 0;

    for (pokemon in data){
        let table = document.getElementById("pokemonTable");
        x = x + 1;
        let row = table.insertRow(1);
        let cell1 = row.insertCell(0);
        let cell2 = row.insertCell(1);

        console.log(data[pokemon].results[x].name)

        cell1.innerHTML = x;
        cell2.innerHTML = data[pokemon].results.name;
    }

}

document.getElementsByTagName("form")[0].addEventListener('submit', searchPokemon)