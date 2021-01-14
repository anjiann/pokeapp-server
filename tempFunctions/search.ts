import { pokeapiBaseClient } from "."
import { Pokemon } from "./Pokemon";

export const getOnePokemon = async (name:string):Promise<Pokemon> => {
    try{
        let res = await pokeapiBaseClient.get(`/pokemon/${name}`);

        let pokemon = new Pokemon();

        pokemon.id = res.data.id;
        pokemon.name = res.data.name;
        pokemon.picture = res.data.sprites.front_default;
        pokemon.weight = res.data.weight;
        pokemon.type = [ res.data.types[0].type.name, res.data.types[1] && res.data.types[1].type.name ];
        return pokemon;
    }catch(e){
        throw new Error();
    }

}

export const getMultiplePokemon = async (limit:number, offset:number):Promise<Pokemon[]> => {
    try{

        let res = await pokeapiBaseClient.get("/pokemon", {
            params:{
                limit,
                offset
            }
        });

        let pokemons:Promise<Pokemon>[] = res.data.results.map((ele:any) => {
            return getOnePokemon(ele.name);
        });

        return await Promise.all(pokemons);
    } catch(e){
        throw new Error();
    }
}

export const getPokemonByGeneration = async (generation:number):Promise<Pokemon[]> => {
    try {

        let res = await pokeapiBaseClient.get(`/generation/${generation}`, {});

        let pokemons:Promise<Pokemon>[] = res.data.pokemon_species.map((ele:any) => {
            return getOnePokemon(ele.name);
        });

        return await Promise.all(pokemons);

    } catch(e){
        throw new Error();
    }
}

export const getPokemonByType = async (type:number):Promise<Pokemon[]> => {
    try {

        let res = await pokeapiBaseClient.get(`/type/${type}`, {});

        let pokemons:Promise<Pokemon>[] = res.data.pokemon.map((ele:any) => {
            return getOnePokemon(ele.pokemon.name);
        });

        return await Promise.all(pokemons);

    } catch(e){
        throw new Error();
    }
}

export const getPokemonBySearch = async (input:string):Promise<Pokemon[]> => {
    try {

        let res = await pokeapiBaseClient.get("/pokemon", {});

        let pokemons:Promise<Pokemon>[] = res.data.results.map((ele:any) => {

            let tmp = ele.name.startsWith(input);

            if (tmp){
                return getOnePokemon(ele.name);
            }

        });

        return await Promise.all(pokemons);
    } catch(e){
        throw new Error();
    }
}

export const getMatchingPokemons = (pokemons:Pokemon[], pokemons2:Pokemon[]) => {

    let returnPokemons:Pokemon[];

    for (let i = 0; i < pokemons.length; i++){
        const pokemon = pokemons[i];
    

        const foundMatch = pokemons2.some(pokemon2 => {
            if (pokemon2.name === pokemon.name){
                return true;
            }
        })

        if (foundMatch){
            returnPokemons.push(pokemons[i]);
        }
        
    }

    return returnPokemons;
}