//
//  CreateJourneyUseCase.swift
//  TravelBlahBlah
//
//  Created by BBangGiJin on 12/28/23.
//

import Foundation

protocol CreateJourneyUseCase {
    func execute(
        requestValue: CreateJourneyUseCaseRequestValue,
        cached: @escaping () -> Void,
        comletion: @escaping () -> Void
    ) -> Cancellable?
}

struct CreateJourneyUseCaseRequestValue {
    let query: JourneyQuery
    let journey: Journey
}

//final class DefaultCreateJourneyUseCase: CreateJourneyUseCase {
//    
//    func execute(requestValue: CreateJourneyUseCaseRequestValue, cached: @escaping () -> Void, comletion: @escaping () -> Void) -> Cancellable? {
//        
//        return 
//    }
//}
