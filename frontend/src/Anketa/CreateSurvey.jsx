import React from 'react';
import styles from './styles/CreateSurvey.module.scss';
import {toast} from 'react-toastify';
import axios from 'axios';

toast.configure();

function validate(description, animal) {
  return {
    description: description.length === 0,
    animal: animal === null
  };
}


export default class CreateSurvey extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            description: '',
            active: true,
            animal: null,
            questions: [],
            givenAnswers: [],
            errors: {
                description: '',
                animal: ''
            }
        }
    }

    render() {
        return (
            <div className={styles.wrapper}>
                <div className={styles.formWrapper}>
                    <h1 className={styles.header}>Kreiraj anketu</h1>
                    <form className={styles.createSurveyForm}>
                        <div className={styles.desc}>
                            <label className={styles.opisLabel}>Opis</label>
                            <br></br>
                            <textarea
                            className={styles.decription}
                            placeholder="Opis"
                            type="text"
                            name="Opis"             
                            />                  
                        </div>
                    </form>
                </div>
            </div>
        );
    }
}