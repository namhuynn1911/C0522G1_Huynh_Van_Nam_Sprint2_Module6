import './App.css';
import axios from "axios";
import React from 'react';

function App() {
    return (
        <div>
            <PersonList/>
        </div>
    );
}

class PersonList extends React.Component {
    state = {
        persons: []
    }
    componentDidMount() {
        axios.get('http://localhost:8080/api/badminton/list/home')
            .then(res => {
                const persons = res.data;
                this.setState({persons});
                console.log(persons)
            })
            .catch(error => console.log(error));
    }

    render() {
        return (
            <tr>
                <td>{this.props.persons.id}</td>
                <td>{this.props.persons.name}</td>
            </tr>
        )
    }
}

export default App;
