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
                            <br/>
                            <textarea
                            className={styles.description}
                            placeholder="Opis"
                            type="text"
                            name="Opis"             
                            />                  
                        </div>
                        <div className={styles.active}>
                            <br/>
                            <label className={styles.activeLabel}>Aktivna</label>
                            <br/>
                            <div className={styles.radioGroup}>
                                <label className={styles.radioGroupLabel}>
                                    <input 
                                    className={styles.isActive}
                                    type="radio"
                                    value="Da"
                                    name="radioActive"
                                    label="Da"
                                    defaultChecked={true}
                                    />
                                    Da
                                </label>
                                <label className={styles.radioGroupLabel}>
                                    <input 
                                    className={styles.isActive}
                                    type="radio"
                                    value="Ne"
                                    name="radioActive"
                                    label="Ne"
                                    />
                                    Ne
                                </label>
                            </div>
                        </div>
                        <div className={styles.chooseAnimal}>
                            <br/>
                                <label className={styles.chooseLable}>Izaberi životinju</label>
                            <br/>
                            <select className={styles.picker}>
                                <option value="Dejzi">Dejzi</option>
                            </select>
                        </div>
                    </form>
                </div>
            </div>
        );
    }
}